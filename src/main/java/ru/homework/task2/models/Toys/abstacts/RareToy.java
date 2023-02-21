package ru.homework.task2.models.Toys.abstacts;

public abstract class RareToy extends Toy {
    public RareToy(Long id, String name, String property) {
        super(id, name, property);
        this.dropRate = RARE_DROP_RATE;
    }

    public RareToy() {
        this.dropRate = RARE_DROP_RATE;
    }
}
