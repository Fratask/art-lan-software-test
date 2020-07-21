package ru.fratask.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fratask.model.entity.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
