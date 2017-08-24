package dao;
import models.Tea;
import models.ItemsAll;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oItemsAllDao implements ItemsAllDao {

    private final Sql2o sql2o;

    public Sql2oItemsAllDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

}