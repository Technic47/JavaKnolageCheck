package ru.homework.task2.models.lotteryStuff;

import org.springframework.stereotype.Component;
import ru.homework.task2.models.Toys.abstacts.*;
import ru.homework.task2.models.Toys.toyClasses.CardGame;
import ru.homework.task2.models.Toys.toyClasses.Doll;
import ru.homework.task2.models.Toys.toyClasses.Lego;
import ru.homework.task2.models.Toys.toyClasses.Robot;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static ru.homework.task2.models.Toys.abstacts.Toy.*;

@Component
public class DB {
    private Set<Droppable> toyRepo;
    private final String path;
    private final Random random;

    public DB() {
        this.path = "src/main/resources/static/db.dat";
        this.toyRepo = new HashSet<>();
        this.random = new Random();
//        this.loadBackUp();
    }

    private void saveBackUp() {
        try (FileOutputStream fos = new FileOutputStream(this.path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.toyRepo);
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
            this.toyRepo = (Set<Droppable>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void addValue(Toy value) {
        this.toyRepo.add(value);
    }

    public void delValue(Toy value) {
        this.toyRepo.remove(value);
    }

    public EasyToy getRandomEasyToy() {
        return (EasyToy) getToy(EASY_DROP_RATE, REGULAR_DROP_RATE);
    }

    public RegularToy getRandomRegularToy() {
        return (RegularToy) getToy(REGULAR_DROP_RATE, RARE_DROP_RATE);
    }

    public RareToy getRandomRareToy() {
        return (RareToy) getToy(RARE_DROP_RATE, 1.0);
    }

    private Droppable getToy(double limit1, double limit2) {
        List<Droppable> searchList = this.toyRepo.stream()
                .toList()
                .stream()
                .filter(item -> item.getDropRate() >= limit1 && item.getDropRate() < limit2)
                .toList();
        int size = searchList.size();
        int index = random.nextInt(0, size);
        return searchList.get(index);
    }

    public List<Droppable> getCardGames(){
        return getItems(CardGame.class);
    }
    public List<Droppable> getDolls(){
        return getItems(Doll.class);
    }
    public List<Droppable> getLegos(){
        return getItems(Lego.class);
    }
    public List<Droppable> getRobots(){
        return getItems(Robot.class);
    }

    private List<Droppable> getItems(Class toyClass) {
        return this.toyRepo.stream().toList()
                .stream().filter(item -> item.getClass() == toyClass)
                .toList();
    }
}
