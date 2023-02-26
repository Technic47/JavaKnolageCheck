package ru.homework.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.homework.task2.models.Toys.abstacts.Droppable;
import ru.homework.task2.models.Toys.abstacts.EasyToy;
import ru.homework.task2.models.Toys.abstacts.RareToy;
import ru.homework.task2.models.Toys.abstacts.RegularToy;
import ru.homework.task2.models.Toys.toyClasses.*;
import ru.homework.task2.models.lotteryStuff.DB;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Task2ApplicationTests {
    DB db;
    CardGame cardGame;
    Doll doll;
    Lego lego;
    Robot robot;

    @BeforeEach
    void setUp() {
        this.db = new DB();
        this.cardGame = new CardGame(0L, "testName", "testProperty", "testCount", "testtheme", 0.2);
        this.doll = new Doll(0L, "testName", "testProperty", "testCount", "testtheme", 0.4);
        this.lego = new Lego(0L, "testName", "testProperty", "testCount", "testtheme", 0.2);
        this.robot = new Robot(0L, "testName", "testProperty", "testCount", "testtheme", 0.6);
    }


    @Test
    void dbCreation() {
        assertEquals("src/main/resources/static/db.dat", this.db.getPath());
    }

    @Test
    void dbAddValue() {
        this.db.addValue(cardGame);
        assertThat(this.db.getToyRepo()).isNotEmpty();
        assertTrue(this.cardGame.getId() != 0L);
    }

    @Test
    void testDbDelValue() {
        this.db.addValue(cardGame);
        this.db.delValue(cardGame);
        assertFalse(this.db.getToyRepo().contains(cardGame));
    }

    @Test
    void testDbGetValue() {
        this.db.addValue(cardGame);
        Long itemId = this.cardGame.getId();
        assertEquals(this.db.getValue(itemId), this.cardGame);
        assertNotEquals(this.db.getValue(0L), this.cardGame);
    }

    @Test
    void testDbUpdateValue() throws CloneNotSupportedException {
        CardGameTest cardGameTest = new CardGameTest(0L, "testName", "testProperty", "testCount", "testtheme", 0.2);
        CardGameTest oldValue = (CardGameTest) cardGameTest.clone();
        this.db.addValue(cardGameTest);
        Long itemId = cardGameTest.getId();
        CardGameTest newCardGame = (CardGameTest) this.db.getValue(itemId);
        newCardGame.setTheme("newValue");
        this.db.updateValue(newCardGame, itemId);
        assertEquals(this.db.getValue(itemId), newCardGame);
        assertNotEquals(this.db.getValue(itemId), oldValue);
    }

    @Test
    void testDbGetRandomEasyToy() {
        assertTrue(this.db.getRandomEasyToy() instanceof EasyToy);
    }

    @Test
    void testDbGetRandomRegularToy() {
        assertTrue(this.db.getRandomRegularToy() instanceof RegularToy);
    }

    @Test
    void testDbGetRandomRareToy() {
        assertTrue(this.db.getRandomRareToy() instanceof RareToy);
    }

    @Test
    void testDbGetCardGames() {
        this.db.addValue(cardGame);
        List<Droppable> testList = this.db.getCardGames();
        for (Droppable droppable : testList) {
            assertTrue(droppable instanceof CardGame);
        }
    }

    @Test
    void testDbGetDolls() {
        this.db.addValue(doll);
        List<Droppable> testList = this.db.getDolls();
        for (Droppable droppable : testList) {
            assertTrue(droppable instanceof Doll);
        }
    }

    @Test
    void testDbGetLegos() {
        this.db.addValue(lego);
        List<Droppable> testList = this.db.getLegos();
        for (Droppable droppable : testList) {
            assertTrue(droppable instanceof Lego);
        }
    }

    @Test
    void testDbGetRobots() {
        this.db.addValue(robot);
        List<Droppable> testList = this.db.getRobots();
        for (Droppable droppable : testList) {
            assertTrue(droppable instanceof Robot);
        }
    }

    @Test
    void testGetAllToys(){
        this.db.addValue(cardGame);
        this.db.addValue(doll);
        this.db.addValue(lego);
        this.db.addValue(robot);
        List<Droppable> testList = this.db.getAllToys();
        assertThat(testList).isNotEmpty();
    }
}
