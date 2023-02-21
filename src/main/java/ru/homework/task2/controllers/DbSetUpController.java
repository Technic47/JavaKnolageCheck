package ru.homework.task2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.homework.task2.models.Toys.abstacts.Droppable;
import ru.homework.task2.models.Toys.abstacts.Toy;
import ru.homework.task2.models.Toys.toyClasses.CardGame;
import ru.homework.task2.models.Toys.toyClasses.Doll;
import ru.homework.task2.models.Toys.toyClasses.Lego;
import ru.homework.task2.models.Toys.toyClasses.Robot;

import java.lang.reflect.Field;

@Controller
@RequestMapping("/db")
public class DbSetUpController extends MainController {
    @GetMapping("/setup")
    public String setUp(Model model) {
        model.addAttribute("newCardGame", new CardGame());
        model.addAttribute("newDoll", new Doll());
        model.addAttribute("newLego", new Lego());
        model.addAttribute("newRobot", new Robot());
        this.getToys(model);
        return "/db/setup";
    }


    @PostMapping("/newToy")
    public String newToy(
            CardGame cardGame,
            Doll doll,
            Lego lego,
            Robot robot,
            @RequestParam(value = "itemType", required = false) String toyType

    ) {
        switch (toyType) {
            case "CardGame" -> this.db.addValue(cardGame);
            case "Doll" -> this.db.addValue(doll);
            case "Lego" -> this.db.addValue(lego);
            case "Robot" -> this.db.addValue(robot);
        }
        return "redirect:/db/setup";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        Droppable toy = this.db.getValue(id);
        String className = toy.getClass().getSimpleName();
        switch (className) {
            case "CardGame" -> {
                model.addAttribute("type", className);
                model.addAttribute("item", (CardGame) toy);
            }
            case "Doll" -> {
                model.addAttribute("type", className);
                model.addAttribute("item", (Doll) toy);
            }
            case "Lego" -> {
                model.addAttribute("type", className);
                model.addAttribute("item", (Lego) toy);
            }
            case "Robot" -> {
                model.addAttribute("type", className);
                model.addAttribute("item", (Robot) toy);
            }
        }
        model.addAttribute("newCardGame", new CardGame());
        model.addAttribute("newDoll", new Doll());
        model.addAttribute("newLego", new Lego());
        model.addAttribute("newRobot", new Robot());
        return "/db/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(Toy item, Model model, @PathVariable("id") Long id){
        this.db.update(item, id);
        return "redirect:/db/setup";
    }

    @PostMapping("/backup")
    public String backUp(
            @RequestParam(value = "backup", required = false, defaultValue = "1") Integer action
    ) {
        switch (action) {
            case 1 -> this.db.saveBackUp();
            case 0 -> this.db.loadBackUp();
        }
        return "redirect:/db/setup";
    }
}
