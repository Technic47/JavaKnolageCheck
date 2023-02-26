package ru.homework.task2.models.Toys.toyClasses;

public class CardGameTest extends CardGame implements Cloneable{
    public CardGameTest(Long id, String name, String property, String peopleCount, String theme, Double dropRate) {
        super(id, name, property, peopleCount, theme, dropRate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
