package ru.fratask.service;

import ru.fratask.model.entity.Animal;

import java.util.List;

public interface AnimalService {

    Animal add(Animal animal);

    Animal update(Animal animal);

    Animal delete(Animal animal);

    List<Animal> getAllAnimalsByUser();

    Animal getInfoByAnimalId(Long id);

}
