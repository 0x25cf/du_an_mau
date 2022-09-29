package repository;

import model.Product;
import model.ProductColor;

import java.util.List;

public class RepoProductColor extends DataQuery {

    public String[] selectAllName() {
        return ((List<String>)createQuery("SELECT PC.Name FROM ProductColor PC")
                .list())
                .toArray(new String[0]);
    }

    public model.ProductColor findByName(String product_color_name) {
        return
            (model.ProductColor)
            createQuery("FROM ProductColor PC WHERE PC.Name = " + SQLStr(product_color_name))
                .list()
                .get(0);
    }

    public String findIdByName(String prodict_color_name) {
        return findByName(prodict_color_name).getId();
    }

    public String selectId(String product_color_id) {
        return
            createQuery("SELECT PC.id FROM ProductColor PC WHERE PC.Code =" + SQLStr(product_color_id))
                .list()
                .get(0)
                .toString();
    }
}
