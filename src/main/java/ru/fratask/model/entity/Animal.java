package ru.fratask.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String sex;
    private Date birthday;

    public Animal() {
    }

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
