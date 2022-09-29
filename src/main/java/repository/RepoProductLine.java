package repository;

import java.util.List;

public class RepoProductLine extends DataQuery {

    public String[] findAllName() {
        return ((List<String>)createQuery("SELECT PL.Name FROM ProductLine PL")
                .list())
                .toArray(new String[0]);
    }

    public String findIdByName(String product_line_name) {
        return findByName(product_line_name).getId();
    }

    public model.ProductLine findByName(String product_line_name) {
        return
            (model.ProductLine)
            createQuery("FROM ProductLine PL WHERE PL.Name = " + SQLStr(product_line_name))
                    .list()
                    .get(0);
    }

}
