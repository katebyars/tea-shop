package dao;
import models.ItemsAll;
import models.Tea;

public interface TeaDao {

    //CREATE

    void add(Tea tea);

    //READ
    Tea findById(int id);

    //UPDATE

    //DELETE
}
