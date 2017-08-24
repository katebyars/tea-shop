package dao;


import models.Accoutrements;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oAccoutrementsDao implements AccoutrementsDao {

    private final Sql2o sql2o;
    public Sql2oAccoutrementsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Accoutrements accoutrements) {
        String sql = "INSERT INTO accoutrements (name, price, image, type, maker) VALUES (:name, :price, :image, :type, :maker)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(accoutrements)
                    .executeUpdate()
                    .getKey();
            accoutrements.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Accoutrements findById(int id){
        String sql = "SELECT * FROM accoutrements WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Accoutrements.class);
        }
    }
}
