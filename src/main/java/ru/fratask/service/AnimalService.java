package ru.fratask.service;

import ru.fratask.model.dto.animal.AddAnimalDto;
import ru.fratask.model.dto.animal.DeleteAnimalDto;
import ru.fratask.model.dto.animal.UpdateAnimalDto;
import ru.fratask.model.entity.Animal;

import java.util.List;

public interface AnimalService {

    Animal add(AddAnimalDto animal);

    Animal update(UpdateAnimalDto animal);

    Animal delete(DeleteAnimalDto animal);

    List<Animal> getAllAnimalsByUser(String username);

    Animal getInfoByAnimalId(Long id);

}
