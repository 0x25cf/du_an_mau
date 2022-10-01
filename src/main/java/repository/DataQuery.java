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

    public String SQLStr(String text) {
        return "\'" + text + "\'";
    }
}
