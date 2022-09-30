package repository;

import model.Product;
import model.ProductDetail;

import java.util.ArrayList;
import java.util.List;

public class RepoProductDetail extends DataQuery {

    public ArrayList<ProductDetail> findAll() {
        return (ArrayList<ProductDetail>) createQuery("FROM ProductDetail").list();
    }

    public void insert(ProductDetail product_detail) {
        var s = openSession();
        s.beginTransaction();
        s.persist(product_detail);
        s.getTransaction().commit();
    }

    public model.ProductDetail findById(String product_id) {
        var result = (List<model.ProductDetail>)createQuery("FROM " +
            ProductDetail.class.getSimpleName() + " PD " +
            "WHERE PD.ProductId = " + SQLStr(product_id)
        ).list();
        return result.get(0);
    }
}
