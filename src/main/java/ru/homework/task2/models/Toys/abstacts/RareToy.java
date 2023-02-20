package ru.homework.task2.models.Toys.abstacts;

public abstract class RareToy extends Toy {
    public RareToy(Long id, String name, String property) {
        super(id, name, property);
        this.dropRate = 0.8;
    }

    public RareToy() {
        this.dropRate = 0.8;
    }
}
