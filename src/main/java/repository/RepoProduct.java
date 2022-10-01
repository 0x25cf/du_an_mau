package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class RepoProduct extends DataQuery {

    public boolean findName(String product_id) {
        return !(createQuery("SELECT P.id FROM Product P WHERE P.Name = " + SQLStr(product_id))
                .list()
                .isEmpty());
    }

    public ArrayList<String> findAllProductId() {
        return (ArrayList<String>) createQuery("""
                SELECT P.ProductId FROM Product P
                """).list();
    }

    public ArrayList<String> findAllProductName() {
        return (ArrayList<String>) createQuery("""
                SELECT P.Name FROM Product P
                """).list();
    }

    public String findIdByProductId(String product_id) {
        return (createQuery("SELECT P.id FROM Product P WHERE P.ProductId = " + SQLStr(product_id))
                .list()).get(0).toString();
    }

    public ArrayList<model.Product> findByName(String product_name) {
        return new ArrayList<model.Product>(createQuery("FROM Product P WHERE P.Name = " + SQLStr(product_name))
                    .list());
    }

    public String findIdByName(String product_name) {
        return findByName(product_name).get(0).getId();
    }

    public ArrayList<model.Product> findById(String product_id) {
        return (ArrayList<Product>)
                (createQuery("FROM Product P WHERE P.ProductId = " + SQLStr(product_id)))
                .list();
    }

    public String findNameById(String product_id) {
        var result = findById(product_id);
        if (result.isEmpty()) return "";
        return result.get(0).getName();
    }
}
