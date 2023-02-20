package ru.homework.task2.models.Toys.toyClasses;

import ru.homework.task2.models.Toys.abstacts.RegularToy;

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
}
