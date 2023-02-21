package ru.homework.task2.models.Toys.abstacts;

public interface Droppable {
    Long getId();
    void setId(Long id);
    String getName();
    String getProperty();
    Double getDropRate();
}
