package org.navi.dao;

import org.navi.interfaces.DaoInterface;
import org.navi.pojo.Animal;

import java.util.List;
import java.util.Objects;

public class DaoImpl implements DaoInterface<Animal> {

    List<Animal> animals;
    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public void save(Animal animal) {
        animals.add(animal);

    }

    @Override
    public void update(Animal animal, String[] params) {
        animal.setName(Objects.requireNonNull(params[0], "Name can't be null"));
        animal.setBreed(Objects.requireNonNull(params[1],"breed can't be null"));

    }

    @Override
    public void delete(Animal animal) {
        animals.remove(animal);

    }
}
