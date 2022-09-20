package br.cap.sistemas.bibliacelular.db.tabelas;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by cap on 20/09/2022
 */


public interface CapitulosDao {

    @Query("SELECT * FROM capitulos")
    List<Capitulos> getAll();

    @Query("SELECT * FROM capitulos WHERE id IN (:capitulosIds)")
    List<Capitulos> loadAllByIds(int[] capitulosIds);

    @Query("SELECT COUNT(id) FROM capitulos")
    int getCount();

    @Insert
    void insert(Capitulos... capitulos);

    @Update
    void update(Capitulos... capitulos);

    @Delete
    void delete(Capitulos capitulos);

    @Query("DELETE FROM capitulos")
    void deleteAllRegisterCapitulos();

}