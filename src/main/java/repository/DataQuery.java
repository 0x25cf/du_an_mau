package repository;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataQuery {
    private Configuration config;

    public DataQuery() {
        this.config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Product.class)
                .addAnnotatedClass(Producer.class)
                .addAnnotatedClass(ProductColor.class)
                .addAnnotatedClass(ProductLine.class)
                .addAnnotatedClass(ProductDetail.class)
                .addAnnotatedClass(RepoStaff.class)
                .configure()
        ;
    }

    public SessionFactory createSessionFactory() {
        return config.buildSessionFactory();
    }

    public Session openSession() {
        return this.createSessionFactory().openSession();
    }

    public org.hibernate.query.Query createQuery(String sql_text) {
        return this.openSession().createQuery(sql_text);
    }

    public boolean addProductColor(String id, String name) {
        var s = this.openSession();
        s.beginTransaction();
        s.persist(new model.ProductDetail(
                "11dbc44a-26e3-481c-a048-5fb6f7260831",
                "e813933b-a50d-4d65-b039-43de00c89139",
                "36d173b4-2504-4256-ac01-1f4dc7f83193",
                "151983c5-52cb-4a12-91a5-338704ee5b67"
        ));
        s.getTransaction().commit();
        return true;
    }

    public String SQLStr(String text) {
        return "\'" + text + "\'";
    }
}
