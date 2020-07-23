package ru.fratask.model.entity;

import java.time.LocalDateTime;

public class Dog extends Animal {

    public Dog(String name, String sex, LocalDateTime birthday, String owner) {
        super(name, sex, birthday, owner);
    }

}
