package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RareToy;

import static org.thymeleaf.util.StringUtils.concat;

public class Lego extends RareToy {
    private String size;
    private String theme;

    public Lego(Long id, String name, String property, String size, String theme) {
        super(id, name, property);
        this.size = size;
        this.theme = theme;
    }

    public Lego() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String getProperty() {
        return concat("Конструктор " + name + " " + size + " на тему ", theme);
    }
}
