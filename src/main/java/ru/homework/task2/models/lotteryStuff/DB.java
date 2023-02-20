package ru.homework.task2.models.lotteryStuff;

import org.springframework.stereotype.Component;
import ru.homework.task2.models.Toys.abstacts.Droppable;
import ru.homework.task2.models.Toys.abstacts.Toy;
import ru.homework.task2.models.Toys.toyClasses.CardGame;
import ru.homework.task2.models.Toys.toyClasses.Doll;
import ru.homework.task2.models.Toys.toyClasses.Lego;
import ru.homework.task2.models.Toys.toyClasses.Robot;

import java.io.*;
import java.util.*;

@Component
public class DB {
    private Map<String, List<Droppable>> repo;
    private final Set<CardGame> cardGameRepo;
    private final Set<Doll> dollRepo;
    private final Set<Lego> legoRepo;
    private final Set<Robot> robotRepo;
    private final String path;
    private final Random random;

    public DB() {
        this.path = "src/main/resources/static/db.dat";
        this.repo = new HashMap<>();
        this.dollRepo = new HashSet<>();
        this.cardGameRepo = new HashSet<>();
        this.legoRepo = new HashSet<>();
        this.robotRepo = new HashSet<>();
        this.random = new Random();
//        this.loadBackUp();
    }

    private void saveBackUp() {
        try (FileOutputStream fos = new FileOutputStream(this.path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.repo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadBackUp() {
//        File dir = new File(this.path);
//        if (!dir.exists()) {
//            dir.mkdir();
//        }

        try (FileInputStream fis = new FileInputStream(this.path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.repo = (Map<String, List<Droppable>>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void addValue(Toy value) {
        String valueName = value.getClass().getSimpleName();
        switch (valueName) {
            case "CardGame" -> this.cardGameRepo.add((CardGame) value);
            case "Doll" -> this.dollRepo.add((Doll) value);
            case "Lego" -> this.legoRepo.add((Lego) value);
            case "Robot" -> this.robotRepo.add((Robot) value);
        }
//        Optional<String> searchItem =
//                this.repo
//                        .keySet()
//                        .stream()
//                        .filter(key -> key.equals(valueName))
//                        .findFirst();
//        searchItem.ifPresentOrElse(s -> this.addToKey(s, value),
//                () -> this.repo.put(valueName, List.of(value)));
    }

    public void delValue(Toy value) {
        String valueName = value.getClass().getSimpleName();
        switch (valueName) {
            case "CardGame" -> this.cardGameRepo.remove((CardGame) value);
            case "Doll" -> this.dollRepo.remove((Doll) value);
            case "Lego" -> this.legoRepo.remove((Lego) value);
            case "Robot" -> this.robotRepo.remove((Robot) value);
        }
//        Optional<String> searchItem =
//                this.repo
//                        .keySet()
//                        .stream()
//                        .filter(key -> key.equals(valueName))
//                        .findFirst();
//        searchItem.ifPresent(s -> this.delFromKey(s, value));
//        searchItem.ifPresentOrElse(s -> this.delFromKey(s, value),
//                () -> {
//                    throw new RuntimeException("No such value: " + valueName);
//                });
    }

    public CardGame getRandomCardGame() {
        int size = this.cardGameRepo.size();
        int index = random.nextInt(0, size);
        return this.cardGameRepo.stream().toList().get(index);
    }

    public Doll getRandomDoll() {
        int size = this.dollRepo.size();
        int index = random.nextInt(0, size);
        return this.dollRepo.stream().toList().get(index);
    }

    public Lego getRandomLego() {
        int size = this.legoRepo.size();
        int index = random.nextInt(0, size);
        return this.legoRepo.stream().toList().get(index);
    }

    public Robot getRandomRobot() {
        int size = this.robotRepo.size();
        int index = random.nextInt(0, size);
        return this.robotRepo.stream().toList().get(index);
    }

    public Set<CardGame> getCardGameRepo() {
        return cardGameRepo;
    }

    public Set<Doll> getDollRepo() {
        return dollRepo;
    }

    public Set<Lego> getLegoRepo() {
        return legoRepo;
    }

    public Set<Robot> getRobotRepo() {
        return robotRepo;
    }

    //    private void addToKey(String key, Droppable value) {
//        List<Droppable> toyList = this.repo.get(key);
//        toyList.add(new CardGame());
//        toyList.add(new CardGame());
//        toyList.add(new CardGame());
//        try {
//            toyList.add(value);
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        this.repo.put(key, toyList);
//    }

//    private void delFromKey(String key, Droppable value) {
//        List<Droppable> toyList = this.repo.get(key);
//        toyList.remove(value);
//        this.repo.put(key, toyList);
//    }
}
