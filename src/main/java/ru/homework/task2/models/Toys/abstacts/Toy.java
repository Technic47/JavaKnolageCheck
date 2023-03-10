package ru.homework.task2.models.Toys.abstacts;

import java.io.Serializable;
import java.util.Objects;

public abstract class Toy implements Droppable, Serializable {
    protected Long id;
    protected String name;
    protected String property;
    protected Double dropRate;

    public static final double REGULAR_DROP_RATE = 0.4;
    public static final double EASY_DROP_RATE = 0.2;
    public static final double RARE_DROP_RATE = 0.8;

    public Toy(Long id, String name, String property) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.dropRate = REGULAR_DROP_RATE;
    }

    public Toy(Long id, String name, String property, Double dropRate) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.dropRate = dropRate;
    }

    public Toy() {
        this.id = 0L;
        this.name = "";
        this.property = "";
        this.dropRate = REGULAR_DROP_RATE;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProperty() {
        return property;
    }

    public Double getDropRate() {
        return dropRate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setDropRate(Double dropRate) {
        this.dropRate = dropRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return Objects.equals(id, toy.id) && Objects.equals(name, toy.name) && Objects.equals(property, toy.property) && Objects.equals(dropRate, toy.dropRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, property, dropRate);
    }
}
