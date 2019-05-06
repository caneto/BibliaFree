package br.cap.sistemas.bibliacelular.db.util;

import android.support.annotation.NonNull;

import br.cap.sistemas.bibliacelular.db.AppDatabase;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;

public class DatabaseInicializador {

    // Simulate a blocking operation delaying each Loan insertion with a delay:
    private static final int DELAY_MILLIS = 500;

    public static void encheAsync(final AppDatabase db) {

        EncheDbAsync task = new EncheDbAsync(db);
    //    task.execute();
    }

    public static void encheSync(@NonNull final AppDatabase db) {
        encheComDadosDeTeste(db);
    }

    private static BibliaTitulos adicionaSeriados(final AppDatabase db, final String nomeseriado,
                                                  final String temporadaseriado, final String episodiostemporadaseriado) {
        BibliaTitulos seriados = new BibliaTitulos();
    //    seriados.setNomeseriado(nomeseriado);
   //     seriados.setTemporadaseriado(temporadaseriado);
  //      seriados.setEpisodiostemporadaseriado(episodiostemporadaseriado);
       // db.seriadosModel().insertSeriados(seriados);
        return seriados;
    }

    private static void encheComDadosDeTeste(AppDatabase db) {
       // db.seriadosModel().deleteAll();

        BibliaTitulos user1 = adicionaSeriados(db,  "Arrow", "6", "22");
        BibliaTitulos user2 = adicionaSeriados(db,  "Flash", "4", "22");
        adicionaSeriados(db,  "Dc Legends", "2", "22");
        adicionaSeriados(db, "Shield","5","22");
    }

    private static class EncheDbAsync {//extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        EncheDbAsync(AppDatabase db) {
            mDb = db;
            encheComDadosDeTeste(mDb);
        }

        //@Override
        //protected Void doInBackground(final Void... params) {
        //    encheComDadosDeTeste(mDb);
        //    return null;
        //}

    }
}
