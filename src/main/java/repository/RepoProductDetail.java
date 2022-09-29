package repository;

import model.ProductDetail;

import java.util.ArrayList;

public class RepoProductDetail extends DataQuery {

    public ArrayList<ProductDetail> selectAll() {
        return (ArrayList<ProductDetail>) createQuery("FROM ProductDetail").list();
    }

    public void insert(ProductDetail product_detail) {
        var s = openSession();
        s.beginTransaction();

        s.persist(new ProductDetail(
                product_detail.getProductId(),
                product_detail.getProductColorId(),
                product_detail.getProducerId(),
                product_detail.getProductLineId()
        ));

        s.getTransaction().commit();
    }
}
