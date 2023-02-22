//package ru.homework.task2.controllers;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ru.homework.task2.models.Toys.abstacts.Droppable;
//import ru.homework.task2.models.Toys.abstacts.Toy;
//import ru.homework.task2.models.Toys.toyClasses.CardGame;
//import ru.homework.task2.models.Toys.toyClasses.Doll;
//import ru.homework.task2.models.Toys.toyClasses.Lego;
//import ru.homework.task2.models.Toys.toyClasses.Robot;
//
//@Controller
//@RequestMapping("/edit")
//@Scope(value = "prototype")
//public class EditController<T extends Toy> extends MainController {
//    private Class<T> toyClass;
//    private T currentObject;
//
//
//    @GetMapping("/{id}")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        Droppable toy = this.db.getValue(id);
//        String className = toy.getClass().getSimpleName();
//
//        model.addAttribute("type", className);
//        model.addAttribute("item", toy);
////        switch (className) {
////            case "CardGame" -> {
////                model.addAttribute("type", className);
////                CardGame newItem = new CardGame(toy.getId(), toy.getName(), toy.getProperty(), ((CardGame) toy).getPeopleCount(), ((CardGame) toy).getTheme());
////                model.addAttribute("item", newItem);
////            }
////            case "Doll" -> {
////                model.addAttribute("item", (Doll) toy);
////            }
////            case "Lego" -> {
////                model.addAttribute("item", (Lego) toy);
////            }
////            case "Robot" -> {
////                model.addAttribute("item", (Robot) toy);
////            }
////        }
//
//
//        model.addAttribute("newCardGame", new CardGame());
//        model.addAttribute("newDoll", new Doll());
//        model.addAttribute("newLego", new Lego());
//        model.addAttribute("newRobot", new Robot());
//        return "/db/edit";
//    }
//
//    @PostMapping("/{id}")
//    public String update(T item,
////                         CardGame cardGame,
////                         Doll doll,
////                         Lego lego,
////                         Robot robot,
////            , Model model
//                         @PathVariable("id") Long id
//    ) {
//        this.db.update(item, id);
//        return "redirect:/db/setup";
//    }
//
//
//}
