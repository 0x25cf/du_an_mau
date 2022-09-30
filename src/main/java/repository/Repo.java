package repository;

import model.Product;

import java.util.List;

public class Repo<T extends Object> extends DataQuery{

    public boolean insert(T value) {
        var s = openSession();
        s.beginTransaction();
        s.persist(value);
        s.getTransaction().commit();
        return true;
    }

    public boolean update(T value) {
        return true;
    }

//    public String[] selectAllName() {
//        return ((List<String>)createQuery("SELECT PC.Name FROM ProductColor PC")
//                .list())
//                .toArray(new String[0]);
//    }
//
//    public T findByName(String product_color_name) {
//        return
//            (model.ProductColor)
//            createQuery(("FROM " +
//                    T.class.getName() +
//                    " PC WHERE PC.Name = " + SQLStr(product_color_name))
//                .list()
//                .get(0);
//    }
//
//    public String findIdByName(String prodict_color_name) {
//        return findByName(prodict_color_name).getId();
//    }
//
//    public String selectId(String product_color_id) {
//        return
//                createQuery("SELECT PC.id FROM ProductColor PC WHERE PC.Code =" + SQLStr(product_color_id))
//                        .list()
//                        .get(0)
//                        .toString();
//    }
}
