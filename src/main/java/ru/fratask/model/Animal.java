package ru.fratask.model;

import java.util.Date;

public abstract class Animal {

    private String name;
    private String sex;
    private Date birthday;

    public Animal(String name, String sex, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }
}
