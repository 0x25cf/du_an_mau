package repository;

import model.Product;

import java.util.List;

public class Repo<T extends Object> extends DataQuery {

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
        s.merge(value);
        s.getTransaction().commit();
        return true;
    }
}
