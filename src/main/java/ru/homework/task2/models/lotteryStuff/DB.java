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
    private final Set<Droppable> toyRepo;
    private final String path;
    private final Random random;

    public DB() {
        this.path = "src/main/resources/static/db.dat";
        this.toyRepo = new HashSet<>();
        this.random = new Random();
        this.loadBackUp();
    }

    public void saveBackUp() {
        try (FileOutputStream fos = new FileOutputStream(this.path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.toyRepo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadBackUp() {
        File dir = new File(this.path);
        if (!dir.exists()) {
            try {
                dir.createNewFile();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dir.length() == 0) {
            return;
        }
        try (FileInputStream fis = new FileInputStream(this.path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.toyRepo.addAll((Set<Droppable>) ois.readObject());
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

    public List<Droppable> getCardGames() {
        return getItemsByClass(CardGame.class);
    }

    public List<Droppable> getDolls() {
        return getItemsByClass(Doll.class);
    }

    public List<Droppable> getLegos() {
        return getItemsByClass(Lego.class);
    }

    public List<Droppable> getRobots() {
        return getItemsByClass(Robot.class);
    }

    private List<Droppable> getItemsByClass(Class toyClass) {
        return this.toyRepo.stream().toList()
                .stream().filter(item -> item.getClass() == toyClass)
                .toList();
    }

    public List<Droppable> getAllToys() {
        return this.toyRepo.stream().toList();
    }
}
