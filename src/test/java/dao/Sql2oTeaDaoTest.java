package dao;

import models.ItemsAll;
import models.Tea;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;



public class Sql2oTeaDaoTest {

    private Sql2oTeaDao teaDao;
    private Connection conn;
    private Sql2oItemsAllDao itemsAllDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teaDao = new Sql2oTeaDao(sql2o);
        itemsAllDao = new Sql2oItemsAllDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Tea setUpNewTea() {
        return new Tea ("Dragon Jasmine Pear",13.50, "https://unsplash.com/search/photos/green-tea?photo=qhQEyyHWrAQ", "green", "China");
    }


    @Test
    public void addingATeaInstantiatesCorrectly() throws Exception {
        Tea newTea = setUpNewTea();
        teaDao.add(newTea);
        assertTrue(newTea instanceof Tea);
        assertTrue(newTea instanceof ItemsAll);

    }

}