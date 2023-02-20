package ru.homework.task2.models.Toys.abstacts;

public abstract class Toy implements Droppable {
    protected Long id;
    protected String name;
    protected String property;
    protected Double dropRate;

    public Toy(Long id, String name, String property) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.dropRate = 0.4;
    }

    public Toy() {
        this.id = 0L;
        this.name = "";
        this.property = "";
        this.dropRate = 0.4;
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
}
