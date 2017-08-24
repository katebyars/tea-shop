import com.google.gson.Gson;
import dao.Sql2oAccoutrementsDao;
import dao.Sql2oItemsAllDao;
import dao.Sql2oTeaDao;
import exceptions.ApiException;
import models.Tea;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {

    public static void main(String[] args) {
        Sql2oAccoutrementsDao accoutrementsDao;
        Sql2oItemsAllDao itemsAllDao;
        Sql2oTeaDao teaDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/teaco.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'"; //check me!

        Sql2o sql2o = new Sql2o(connectionString, "", "");
        accoutrementsDao = new Sql2oAccoutrementsDao(sql2o);
        itemsAllDao = new Sql2oItemsAllDao(sql2o);
        teaDao = new Sql2oTeaDao(sql2o);
        conn = sql2o.open();

        //create
        post("/teas/new", "application/json", (req, res) ->{
            Tea tea = gson.fromJson(req.body(), Tea.class);
            teaDao.add(tea);
            res.status(201);
            return gson.toJson(tea);
        });


        get("/teas/:id", "application/json", (req, res) -> {
            int teaId = Integer.parseInt(req.params("id"));

            System.out.println(req);
            System.out.println(res);

            Tea teaToFind = teaDao.findById(teaId);

            if(teaToFind == null) {
               throw new ApiException(404, String.format("No tea with the id \'%s\' exists", req.params("id")));
                //throw new ApiException(404, "tea", req.params("id"));
            }
            return null;
        });

        //read
        get("/teas", "application/json", (req, res) ->{
            return gson.toJson(teaDao.getAll());
        });

        exception(ApiException.class, (exc, req, res) ->{
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        //filter
        after((req, res) -> {
            res.type("application/json");
        });
    }
}
