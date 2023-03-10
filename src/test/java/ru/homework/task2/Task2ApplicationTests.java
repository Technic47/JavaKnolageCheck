package ru.homework.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.homework.task2.models.Toys.abstacts.Droppable;
import ru.homework.task2.models.Toys.abstacts.EasyToy;
import ru.homework.task2.models.Toys.abstacts.RareToy;
import ru.homework.task2.models.Toys.abstacts.RegularToy;
import ru.homework.task2.models.Toys.toyClasses.*;
import ru.homework.task2.models.lotteryStuff.DB;
import ru.homework.task2.models.lotteryStuff.Dropper;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Task2ApplicationTests {
    @Autowired
    DB db;
    @Autowired
    Dropper dropper;
    CardGame cardGame;
    Doll doll;
    Lego lego;
    Robot robot;
    static Long DEF_ID = 0L;

    /*
    DB Tests
     */
    @BeforeEach
    void setUp() {
        this.cardGame = new CardGame(DEF_ID, "testName", "testProperty", "testCount", "testtheme", 0.2);
        this.doll = new Doll(DEF_ID, "testName", "testProperty", "testCount", "testtheme", 0.4);
        this.lego = new Lego(DEF_ID, "testName", "testProperty", "testCount", "testtheme", 0.2);
        this.robot = new Robot(DEF_ID, "testName", "testProperty", "testCount", "testtheme", 0.6);
    }


    @Test
    void testDbCreation() {
        assertEquals("src/main/resources/static/db.dat", this.db.getPath());
    }

    @Test
    void testDbAddValue() {
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
        Long wrongId = 999999L;
        this.db.addValue(cardGame);
        Long itemId = this.cardGame.getId();
        assertEquals(this.db.getValue(itemId), this.cardGame);
        assertNotEquals(this.db.getValue(0L), this.cardGame);
        assertThatThrownBy(() -> this.db.getValue(wrongId))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Toy with id = " + wrongId + " is not present");
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
    @Test
    void testCheckByDropRate(){
        this.db.addValue(cardGame);
        this.db.addValue(doll);
        this.db.addValue(lego);
        this.db.addValue(robot);
        assertFalse(this.db.checkByDropRate(0.1));
        assertTrue(this.db.checkByDropRate(1.0));
    }

    /*
    Dropper
     */

    @Test
    void testDropperCreation(){
        assertThat(this.dropper.getNewIntSet().length).isEqualTo(10);
    }

    @Test
    void testDropperSeed(){
        assertTrue(Arrays.stream(this.dropper.getNewIntSet()).allMatch(n -> n == 1 || n == 0));
    }

    @Test
    void testDropperCheck(){
        int[] testArr = this.dropper.getNewIntSet();
        int[] wrongArr = {2,2,2,2,2,2,2,2,2,2};
        assertThat(this.dropper.check(testArr)).isEqualTo(1.0);
        assertThat(this.dropper.check(wrongArr)).isEqualTo(0.0);
    }
    @Test
    void testDropperGetIntSet(){
        int[] testArr = this.dropper.getNewIntSet();
        int[] testArr2 = this.dropper.getIntSet();
        assertThat(testArr2.length).isEqualTo(10);
        assertArrayEquals(testArr, testArr2);
    }



}
