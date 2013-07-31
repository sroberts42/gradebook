package gradebook.model;

import java.util.List;
import java.util.ArrayList;

/**
 *GradebookImpl is the implementation of the interface GradebookDB
 *
 *@author Susan Roberts
 *@param <T>, abstract data type
 */

public class GradebookImpl<T> implements GradebookDB<T> {

    private List<T> list = new ArrayList<T>();

    public void delete(T t) {
        list.remove(t);
    }

    public void add(T t) {
        list.add(t);
    }

    public T get(int index) {
        return list.get(index);
    }

    public List<T> getAll() {
        return list;
    }

    public int size() {
        return list.size();
    }
}
