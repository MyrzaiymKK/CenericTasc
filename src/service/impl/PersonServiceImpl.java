package service.impl;

import database.DataBase;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person, Integer> {
    private final DataBase dataBase;

    public PersonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(List<Person> t) {
        dataBase.people.addAll(t);
        return "Successfully";
    }

    @Override
    public List<Person> getAll() {

        return dataBase.people;
    }

    @Override
    public List<Person> sortByName(Integer integer) {
        List<Person> people = new ArrayList<>(dataBase.people);
        if (integer == 1) {
            Comparator<Person> comparator = Comparator.comparing(Person::getName);
            people.sort(comparator);
            return people;
        } else if (integer == 2) {
            Comparator<Person> comparator = Comparator.comparing(Person::getName).reversed();
            people.sort(comparator);
            return people;
        }
        throw new RuntimeException("kata");
    }

    @Override
    public List<Person> filterByGender(Integer integer) {
        List<Person> people = new ArrayList<>();
        for (Person person : dataBase.people) {
            if (integer == 1) {
                if ("female".equalsIgnoreCase(String.valueOf(person.getGender()))) {
                    people.add(person);
                }
            } else if (integer == 2) {
                if ("male".equalsIgnoreCase(String.valueOf(person.getGender()))) {
                    people.add(person);
                }
            }
        }
        return people;
    }

    @Override
    public List<Person> clear() {
        dataBase.people.clear();
        return dataBase.people;
    }
}
