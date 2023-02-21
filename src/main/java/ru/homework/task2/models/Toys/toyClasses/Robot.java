package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RegularToy;

import java.util.Objects;

import static org.thymeleaf.util.StringUtils.concat;

public class Robot extends RegularToy {
    private String type;
    private String action;

    public Robot(Long id, String name, String property, String type, String action) {
        super(id, name, property);
        this.type = type;
        this.action = action;
    }

    public Robot() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getProperty() {
        return concat("Робот " + type + " " + name + " который " + action);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(type, robot.type) && Objects.equals(action, robot.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, action);
    }
}
