package br.cap.sistemas.bibliacelular.db.tabelas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by cap on 20/09/2022
 */

@Dao
public interface BibliaTitulosDao {

    @Query("SELECT * FROM bibliatitulos")
    List<BibliaTitulos> getAll();

    @Query("SELECT * FROM bibliatitulos WHERE id IN (:bibliatitulosIds)")
    List<BibliaTitulos> loadAllByIds(int[] bibliatitulosIds);

    @Query("SELECT COUNT(id) FROM bibliatitulos")
    int getCount();

    @Insert
    void insert(BibliaTitulos... bibliaTitulos);

    @Update
    void update(BibliaTitulos... bibliaTitulos);

    @Delete
    void delete(BibliaTitulos bibliaTitulos);

    @Query("DELETE FROM bibliatitulos")
    void deleteAllRegisterBibliaTitulos();

}