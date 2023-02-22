package ru.homework.task2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.homework.task2.models.Toys.abstacts.Droppable;
import ru.homework.task2.models.Toys.toyClasses.CardGame;
import ru.homework.task2.models.Toys.toyClasses.Doll;
import ru.homework.task2.models.Toys.toyClasses.Lego;
import ru.homework.task2.models.Toys.toyClasses.Robot;

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
        model.addAttribute("type", className);
        CardGame cardGame = new CardGame();
        Doll doll = new Doll();
        Lego lego;
        Robot robot;
//        model.addAttribute("item", toy);
        switch (className) {
            case "CardGame" -> {
                cardGame = new CardGame(toy.getId(), toy.getName(), toy.getProperty(), ((CardGame) toy).getPeopleCount(), ((CardGame) toy).getTheme(), toy.getDropRate());
                model.addAttribute("cardGame", cardGame);
                model.addAttribute("doll", new Doll());
                model.addAttribute("lego", new Lego());
                model.addAttribute("robot", new Robot());
            }
            case "Doll" -> {
                doll = new Doll(toy.getId(), toy.getName(), toy.getProperty(), ((Doll) toy).getSize(), ((Doll) toy).getTheme(), toy.getDropRate());
                model.addAttribute("doll", doll);
                model.addAttribute("cardGame", new CardGame());
                model.addAttribute("lego", new Lego());
                model.addAttribute("robot", new Robot());

            }
            case "Lego" -> {
                lego = new Lego(toy.getId(), toy.getName(), toy.getProperty(), ((Lego) toy).getSize(), ((Lego) toy).getTheme(), toy.getDropRate());
                model.addAttribute("lego", lego);
                model.addAttribute("cardGame", new CardGame());
                model.addAttribute("doll", new Doll());
                model.addAttribute("robot", new Robot());
            }
            case "Robot" -> {
                robot = new Robot(toy.getId(), toy.getName(), toy.getProperty(), ((Robot) toy).getType(), ((Robot) toy).getAction(), toy.getDropRate());
                model.addAttribute("robot", robot);
                model.addAttribute("cardGame", new CardGame());
                model.addAttribute("doll", new Doll());
                model.addAttribute("lego", new Lego());
            }
        }
        return "/db/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(CardGame cardGame,
                         Doll doll,
                         Lego lego,
                         Robot robot,
//            , Model model
                         @PathVariable("id") Long id
    ) {
//        this.db.update(item, id);
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
