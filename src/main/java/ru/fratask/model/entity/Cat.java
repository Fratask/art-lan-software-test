package ru.fratask.model.entity;

import java.time.LocalDateTime;

public class Cat extends Animal {

    public Cat(String name, String sex, LocalDateTime birthday, String owner) {
        super(name, sex, birthday, owner);
    }

}
