package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.EasyToy;

import static org.thymeleaf.util.StringUtils.concat;

public class CardGame extends EasyToy {
    private String peopleCount;
    private String theme;

    public CardGame(Long id, String name, String property, String peopleCount, String theme) {
        super(id, name, property);
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
}
