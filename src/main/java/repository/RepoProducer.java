package repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class RepoProducer extends DataQuery {

    public String[] findAllName() {
        return ((List<String>)createQuery("SELECT P.Name FROM Producer P")
                .list())
                .toArray(new String[0]);
    }

    public String findIdByName(String producer_name) {
        return findByName(producer_name).getId();
    }

    public model.Producer findByName(String producer_name) {
        return
            (model.Producer)
            createQuery("SELECT P.id FROM Producer P WHERE P.Name = " + SQLStr(producer_name))
                .list()
                .get(0);
    }

}
