package gradebook.model;

import java.util.List;

public interface GradebookDB<T> {

    public void delete(T t);

    public void add(T t);

    public T get(int index);

    public List<T> getAll();

    public int size();

}