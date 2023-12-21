package service.impl;

import database.DataBase;
import enam.Gender;
import model.Animal;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal, Integer> {

    private final DataBase dataBase;

    public AnimalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String add(List<Animal> t) {
        dataBase.animals.addAll(t);
        return "Success";
    }

    @Override
    public List<Animal> getAll() {
        return dataBase.animals;
    }

    @Override
    public List<Animal> sortByName(Integer integer) {
        List<Animal> animals = new ArrayList<>(dataBase.animals);
        if (integer == 1) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
            animals.sort(comparator);
            return animals;
        } else if (integer == 2) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName).reversed();
            animals.sort(comparator);
            return animals;
        }
        throw new RuntimeException("kata");
    }

    @Override
    public List<Animal> filterByGender(Integer integer) {
        List<Animal> animals = new ArrayList<>();
        for (Animal animal : dataBase.animals) {
            if (integer == 1) {
                if ("female".equalsIgnoreCase(String.valueOf(animal.getGender()))) {
                    animals.add(animal);
                }
            } else if (integer == 2) {
                if ("male".equalsIgnoreCase(String.valueOf(animal.getGender()))) {
                    animals.add(animal);
                }
            }
        }
        return animals;
    }

    @Override
    public List<Animal> clear() {
        dataBase.animals.clear();
        return dataBase.animals;
    }
}
