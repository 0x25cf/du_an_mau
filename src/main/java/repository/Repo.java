package repository;

import model.Product;

import java.util.List;

public class Repo<T> extends DataQuery {

    public boolean insert(T value) {
        var s = openSession();
        s.beginTransaction();
        s.persist(value);
        s.getTransaction().commit();
        return true;
    }

    public boolean update(T value) {
        var s = openSession();
        s.beginTransaction();
        s.detach(value);
        s.merge(value);
        s.getTransaction().commit();
        return true;
    }
}
