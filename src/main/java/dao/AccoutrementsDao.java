package dao;

import models.Accoutrements;

public interface AccoutrementsDao {

    //CREATE
    void add(Accoutrements accoutrements);

    //READ
    Accoutrements findById(int id);
}
