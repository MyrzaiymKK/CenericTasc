package service;

import java.util.List;

public interface GenericService<T, I> {
    String add(List<T>t);
    List<T> getAll();
    List<T> sortByName(I i);
    List<T> filterByGender(I i);
    List<T> clear();

}
