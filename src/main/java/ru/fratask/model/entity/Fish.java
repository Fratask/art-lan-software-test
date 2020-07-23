package ru.fratask.model.entity;

import java.time.LocalDateTime;

public class Fish extends Animal {

    public Fish(String name, String sex, LocalDateTime birthday, String owner) {
        super(name, sex, birthday, owner);
    }

}
