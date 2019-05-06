package br.cap.sistemas.bibliacelular.db;

import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulosDao;

public abstract class AppDatabase  {

    public abstract BibliaTitulosDao BibliaTituloModel();



                    //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    //.allowMainThreadQueries()
                    //.build();


}