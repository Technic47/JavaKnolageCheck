package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RareToy;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lego lego)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(size, lego.size) && Objects.equals(theme, lego.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, theme);
    }
}
