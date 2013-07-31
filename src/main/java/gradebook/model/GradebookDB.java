package gradebook.model;

import java.util.List;

/**
 *GradebookDB is the interface that defines the storage
 *of objects in this project
 *
 *@author Susan Roberts
 *@param <T>, abstract data type
 */

public interface GradebookDB<T> {

    void delete(T t);

    void add(T t);

    T get(int index);

    List<T> getAll();

    int size();

}
