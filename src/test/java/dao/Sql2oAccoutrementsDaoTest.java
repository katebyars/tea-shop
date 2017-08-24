package dao;

import models.Accoutrements;
import models.ItemsAll;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oAccoutrementsDaoTest {

    private Sql2oAccoutrementsDao accoutrementsDao;
    private Connection conn;
    private Sql2oItemsAllDao itemsAllDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        accoutrementsDao = new Sql2oAccoutrementsDao(sql2o);
        itemsAllDao = new Sql2oItemsAllDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void AccoutrementsInstantiatesCorrectly(){
        Accoutrements newThing = helper();
        assertTrue(newThing instanceof Accoutrements);
        assertTrue(newThing instanceof ItemsAll);
    }

    @Test
    public void getName(){
        Accoutrements newThing = helper();
        accoutrementsDao.add(newThing);
        Accoutrements foundThing = accoutrementsDao.findById(1);
        assertEquals("Lady Bug Tea Cosy", foundThing.getName());
    }

    //helper
    public Accoutrements helper(){
        return new Accoutrements("Lady Bug Tea Cosy", 20.99, "teacosy.jpg", "Tea Cozy", "Tea Cuties");
    }
}