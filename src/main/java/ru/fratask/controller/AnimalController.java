package ru.fratask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.fratask.model.dto.animal.AddAnimalDto;
import ru.fratask.model.dto.animal.DeleteAnimalDto;
import ru.fratask.model.dto.animal.UpdateAnimalDto;
import ru.fratask.model.entity.Animal;

import java.util.List;

@Controller("animal")
public class AnimalController {

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimalsByUser() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalInfoById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody AddAnimalDto addAnimalDto) {
        return null;
    }

    @PutMapping
    public ResponseEntity<Animal> updateAnimalInfo(@RequestBody UpdateAnimalDto updateAnimalDto) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Animal> deleteAnimal(@RequestBody DeleteAnimalDto deleteAnimalDto) {
        return null;
    }


}
