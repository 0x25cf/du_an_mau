package repository;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class RepoStaff extends DataQuery {

    public RepoStaff() {}

    public model.Staff selectByStaffId(String staff_id) {
        return (model.Staff) this.createQuery("FROM Staff").list().get(0);
    }

    public void add(model.Staff staff) {
        var s = this.openSession();
        s.beginTransaction();

        s.persist(staff);

        s.getTransaction().commit();
    }

    public boolean login(String StaffId, String password) {
        return !(createQuery("FROM Staff WHERE StaffId = " +
                SQLStr(StaffId) +
                " AND " + "password = " +
                SQLStr(password)
        ).list()
        .isEmpty());
    }
}
