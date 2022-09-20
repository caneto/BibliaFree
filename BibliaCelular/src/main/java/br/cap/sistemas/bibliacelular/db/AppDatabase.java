package br.cap.sistemas.bibliacelular.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulosDao;
import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao;

@Database(entities = {
   BibliaTitulos.class,
   Capitulos.class,
}, version = 1)


public abstract class AppDatabase extends RoomDatabase {

    public abstract BibliaTitulosDao BibliaTitulosDao();
    public abstract CapitulosDao CapitulosDao();


                    //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    //.allowMainThreadQueries()
                    //.build();


}