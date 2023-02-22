package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RegularToy;

import java.util.Objects;

import static org.thymeleaf.util.StringUtils.concat;

public class Doll extends RegularToy {
    private String size;
    private String theme;

    public Doll(Long id, String name, String property, String size, String theme, Double dropRate) {
        super(id, name, property, dropRate);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doll doll)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(size, doll.size) && Objects.equals(theme, doll.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, theme);
    }
}
