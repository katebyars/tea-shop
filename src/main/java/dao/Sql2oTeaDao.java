package dao;
import models.Tea;
import models.ItemsAll;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oTeaDao implements TeaDao {

    private final Sql2o sql2o;
    public Sql2oTeaDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Tea tea) {
        String sql = "INSERT INTO teas (name, price, image, type, sourceCountry) VALUES (:name, :price, :image, :type, :sourceCountry)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(tea)
                    .executeUpdate()
                    .getKey();
            tea.setId(id);
        }
    }

    @Override
    public Tea findById(int id) {
        String sql = "SELECT * FROM teas WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tea.class);
        }
    }

    @Override
    public List<Tea> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM teas")
                    .executeAndFetch(Tea.class);
        }
    }
}
