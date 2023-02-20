package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RegularToy;

import static org.thymeleaf.util.StringUtils.concat;

public class Doll extends RegularToy {
    private String size;
    private String theme;

    public Doll(Long id, String name, String property, String size, String theme) {
        super(id, name, property);
        this.size = size;
        this.theme = theme;
    }

    public Doll() {
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
        return concat("Кукла " + name + " " + size + " на тему " + theme);
    }
}
