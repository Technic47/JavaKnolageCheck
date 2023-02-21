package ru.homework.task2.models.Toys.abstacts;

public abstract class EasyToy extends Toy {
    public EasyToy(Long id, String name, String property) {
        super(id, name, property);
        this.dropRate = EASY_DROP_RATE;
    }

    public EasyToy() {
        this.dropRate = EASY_DROP_RATE;
    }
}
