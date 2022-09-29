package service;

import model.Product;

public class Inserter extends repository.DataQuery {

    public boolean Product(model.Product product) {
        var s = openSession();
        s.beginTransaction();
        s.persist(product);
        s.getTransaction().commit();
        return true;
    }

    public boolean ProductColor(model.ProductColor product_color) {
        var s = openSession();
        s.beginTransaction();
        s.persist(product_color);
        s.getTransaction().commit();
        return true;
    }
}
