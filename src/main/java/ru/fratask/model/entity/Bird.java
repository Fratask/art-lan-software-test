package ru.fratask.model.entity;

import java.time.LocalDateTime;

public class Bird extends Animal {

    public Bird(String name, String sex, LocalDateTime birthday, String owner) {
        super(name, sex, birthday, owner);
    }

}
