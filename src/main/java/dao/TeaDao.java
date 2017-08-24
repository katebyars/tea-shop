package dao;
import models.ItemsAll;
import models.Tea;

import java.util.List;

public interface TeaDao {

    //CREATE

    void add(Tea tea);

    //READ
    Tea findById(int id);
    List<Tea> getAll();

    //UPDATE

    //DELETE
}
