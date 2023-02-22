package ru.homework.task2.models.Toys.abstacts;

public abstract class RareToy extends Toy {
    public RareToy(Long id, String name, String property, Double dropRate) {
        super(id, name, property, dropRate);
        this.dropRate = RARE_DROP_RATE;
    }

    public RareToy() {
        this.dropRate = RARE_DROP_RATE;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
