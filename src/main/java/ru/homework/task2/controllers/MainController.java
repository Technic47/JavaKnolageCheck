package ru.homework.task2.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.homework.task2.models.Toys.abstacts.EasyToy;
import ru.homework.task2.models.Toys.abstacts.RareToy;
import ru.homework.task2.models.Toys.abstacts.RegularToy;
import ru.homework.task2.models.lotteryStuff.ArrayHolder;
import ru.homework.task2.models.lotteryStuff.DB;
import ru.homework.task2.models.lotteryStuff.Dropper;


@Controller
@RequestMapping("/")
@Validated
public class MainController {
    private static String USER_NAME = "Default";
    private Dropper dropper;
    protected DB db;

    @GetMapping("/")
    public String hallo() {
        return "/index";
    }

    @PostMapping("/start")
    public String setName(
            @RequestParam(value = "name", required = false) String userName,
            Model model
    ) {
        if (!(userName == null)) {
            USER_NAME = userName;
        }
        model.addAttribute("username", USER_NAME);
        model.addAttribute("numbers", this.dropper.getIntSet());
        model.addAttribute("toys", this.db.getAllToys());
        model.addAttribute("playerArrayHandler", new ArrayHolder(new int[10]));
        return "/lottery";
    }

    @PostMapping("/results")
    public String check(
            @Valid ArrayHolder playerArrayHolder,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "/lottery";
        }
        double result = dropper.check(playerArrayHolder.getArray());
        model.addAttribute("guestValues", result);
        if (result < 0.2) {
            model.addAttribute("message", "Вы отгадали слишком мало значений и ничего не выиграли(");
        } else if (result >= 0.2 && result < 0.5) {
            model.addAttribute("message", "Вы отгадали несколько значений, поздравляю!");
            EasyToy toy = this.db.getRandomEasyToy();
            this.db.delValue(toy);
            model.addAttribute("prize", toy);
        } else if (result >= 0.5 && result < 0.8) {
            model.addAttribute("message", "Вы отгадали много значений, поздравляю!");
            RegularToy toy = this.db.getRandomRegularToy();
            this.db.delValue(toy);
            model.addAttribute("prize", toy);
        } else if (result >= 0.8) {
            model.addAttribute("message", "Вы отгадали очень много значений, вы невероятно везучий человек!!!");
            RareToy toy = this.db.getRandomRareToy();
            this.db.delValue(toy);
            model.addAttribute("prize", toy);
        }
        return "/check";
    }

    protected void getToys(Model model) {
        model.addAttribute("CardGames", db.getCardGames());
        model.addAttribute("Dolls", db.getDolls());
        model.addAttribute("Legos", db.getLegos());
        model.addAttribute("Robots", db.getRobots());
    }

    @Autowired
    public void setDropper(Dropper dropper) {
        this.dropper = dropper;
    }

    @Autowired
    public void setDb(DB db) {
        this.db = db;
    }
}
