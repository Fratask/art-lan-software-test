package ru.fratask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.fratask.model.dto.animal.AddAnimalDto;
import ru.fratask.model.dto.animal.DeleteAnimalDto;
import ru.fratask.model.dto.animal.UpdateAnimalDto;
import ru.fratask.model.entity.Animal;
import ru.fratask.service.AnimalService;
import ru.fratask.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;
    private final TokenService tokenService;

    public AnimalController(AnimalService animalService, TokenService tokenService) {
        this.animalService = animalService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimalsByUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = tokenService.findUserByToken(token).getUsername();
        return ResponseEntity.ok(animalService.getAllAnimalsByUser(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.getInfoByAnimalId(id));
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(HttpServletRequest request, @RequestBody AddAnimalDto addAnimalDto) {
        if (addAnimalDto.getOwner().isEmpty() || addAnimalDto.getOwner().equals("")) {
            String token = request.getHeader("Authorization");
            String username = tokenService.findUserByToken(token).getUsername();
            addAnimalDto.setOwner(username);
        }
        return ResponseEntity.ok(animalService.add(addAnimalDto));
    }

    @PutMapping
    public ResponseEntity<Animal> updateAnimalInfo(HttpServletRequest request, @RequestBody UpdateAnimalDto updateAnimalDto) {
        if (updateAnimalDto.getOwner().isEmpty() || updateAnimalDto.getOwner().equals("")) {
            String token = request.getHeader("Authorization");
            String username = tokenService.findUserByToken(token).getUsername();
            updateAnimalDto.setOwner(username);
        }
        return ResponseEntity.ok(animalService.update(updateAnimalDto));
    }

    @DeleteMapping
    public ResponseEntity<Animal> deleteAnimal(HttpServletRequest request, @RequestBody DeleteAnimalDto deleteAnimalDto) {
        if (deleteAnimalDto.getOwner().isEmpty() || deleteAnimalDto.getOwner().equals("")) {
            String token = request.getHeader("Authorization");
            String username = tokenService.findUserByToken(token).getUsername();
            deleteAnimalDto.setOwner(username);
        }
        return ResponseEntity.ok(animalService.delete(deleteAnimalDto));
    }


}
