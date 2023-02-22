package ru.homework.task2.models.Toys.abstacts;

public abstract class EasyToy extends Toy {
    public EasyToy(Long id, String name, String property, Double dropRate) {
        super(id, name, property, dropRate);
        this.dropRate = EASY_DROP_RATE;
    }

    public EasyToy() {
        this.dropRate = EASY_DROP_RATE;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
