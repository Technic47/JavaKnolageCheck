package ru.homework.task2.models.Toys.abstacts;

public abstract class RegularToy extends Toy {
    public RegularToy(Long id, String name, String property, Double dropRate) {
        super(id, name, property,dropRate);
    }

    public RegularToy() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
