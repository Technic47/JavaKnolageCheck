package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.EasyToy;

import java.util.Objects;

import static org.thymeleaf.util.StringUtils.concat;

public class CardGame extends EasyToy {
    private String peopleCount;
    private String theme;

    public CardGame(Long id, String name, String property, String peopleCount, String theme, Double dropRate) {
        super(id, name, property, dropRate);
        this.peopleCount = peopleCount;
        this.theme = theme;
    }

    public CardGame() {
        super();
    }


    public String getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String getProperty() {
        return concat("Игра " + name + " для " + peopleCount + " человек(а) на тему " + theme);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardGame cardGame)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(peopleCount, cardGame.peopleCount) && Objects.equals(theme, cardGame.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), peopleCount, theme);
    }
}
