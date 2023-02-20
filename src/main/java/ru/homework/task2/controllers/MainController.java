package ru.homework.task2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.homework.task2.models.lotteryStuff.DB;
import ru.homework.task2.models.lotteryStuff.Dropper;

@Controller
@RequestMapping("/")
public class MainController {
    private String userName;
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
        this.userName = userName;
        model.addAttribute("username", this.userName);
        model.addAttribute("numbers", this.dropper.getIntSet());
        return "/lottery";
    }

    @PostMapping("/results")
    public String check(
            @RequestParam(value = "first") Integer firstNumber,
            @RequestParam(value = "second") Integer secondNumber,
            @RequestParam(value = "third") Integer thirdNumber,
            @RequestParam(value = "fourth") Integer fourthNumber,
            @RequestParam(value = "fifth") Integer fifthNumber,
            @RequestParam(value = "sixth") Integer sixthNumber,
            @RequestParam(value = "seventh") Integer seventhNumber,
            @RequestParam(value = "eighth") Integer eighthNumber,
            @RequestParam(value = "ninth") Integer ninthNumber,
            @RequestParam(value = "tenth") Integer tenthNumber,
            Model model
    ) {
        int[] values = new int[]{firstNumber, secondNumber, thirdNumber
                , fourthNumber, fifthNumber, sixthNumber, seventhNumber
                , eighthNumber, ninthNumber, tenthNumber};
        double result = dropper.check(values);
        model.addAttribute("guestValues", result);
        if (result < 0.2) {
            model.addAttribute("message", "Вы отгадали слишком мало значений и ничего не выиграли(");
        } else if (result >= 0.2 && result < 0.5) {
            model.addAttribute("message", "Вы отгадали несколько значений, поздравляю!");
        } else if (result >= 0.5 && result < 0.8) {
            model.addAttribute("message", "Вы отгадали много значений, поздравляю!");
        } else if (result >= 0.8) {
            model.addAttribute("message", "Вы отгадали очень много значений, вы невероятно везучий человек!!!");
        }
        return "/check";
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
