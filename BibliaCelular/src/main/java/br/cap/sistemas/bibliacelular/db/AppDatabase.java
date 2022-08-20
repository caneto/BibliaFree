package br.cap.sistemas.bibliacelular.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulosDao;

@Database(entities = {//External Input

}, version = 1)


public abstract class AppDatabase extends RoomDatabase {

    public abstract BibliaTitulosDao BibliaTituloModel();



                    //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    //.allowMainThreadQueries()
                    //.build();


}