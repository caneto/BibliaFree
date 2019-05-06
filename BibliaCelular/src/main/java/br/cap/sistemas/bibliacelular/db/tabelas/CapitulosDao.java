package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.IOException;

public class CapitulosDao {

    public Capitulos getCapituloPorId(String Id) {
        Realm realm = Realm.getDefaultInstance();

        try {
            Capitulos capitulo = realm.where(Capitulos.class)
                    .equalTo(CapitulosFields.t_id,Id).findFirst();

            // Check if the data is not null, if null there is no user with these Id
            if (capitulo == null) {
                return null;
            }

            return capitulo;

        } catch (Exception e) {
            // print the error
            e.printStackTrace();

        }

        return null;
    }

    public Capitulos getCapituloPorCapitulTexto(String texto, int idtitulo) {
        Realm realm = Realm.getDefaultInstance();

        try {
            Capitulos capitulo = realm.where(Capitulos.class)
                    .equalTo(CapitulosFields.t_capitulo, texto)
                    .equalTo(CapitulosFields.t_titulo_id, idtitulo)
                    .findFirst();

            // Check if the data is not null, if null there is no user with these Id
            if (capitulo == null) {
                return null;
            }

            return capitulo;

        } catch (Exception e) {
            // print the error
            e.printStackTrace();

        }

        return null;
    }

    public RealmResults<Capitulos> getCapituloPorIdTitulo(int tituloId) {
        Realm realm = Realm.getDefaultInstance();

        try {
            RealmResults<Capitulos> results = realm.where(Capitulos.class)
                    .equalTo(CapitulosFields.t_titulo_id,tituloId).findAll();

            // Check if the data is not null, if null there is no user with these Id
            if (results == null || results.size() == 0) {
                return null;
            }

            return results;

        } catch (Exception e) {
            // print the error
            e.printStackTrace();

        }

        return null;
    }


    public RealmResults<Capitulos> getAll() {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<Capitulos> results = realm.where(Capitulos.class)
                    .findAll();

            if (results == null || results.size() == 0) {
                return null;
            }

            return results;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void salvaCapitulos(Capitulos capitulo) {
        saveOrUpdate(capitulo);
    }

    protected void saveOrUpdate(Capitulos capitulo) {
        Realm realm = Realm.getDefaultInstance();
        try {
            //save ususario on realm
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(capitulo);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delAll() {
        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction(); // open a transation
            realm.delete(Capitulos.class); // delete the data
            realm.commitTransaction(); // close the transation

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public static void gravaCapitulosDB (Capitulos capitulos) {

        CapitulosDao capitulosDao  = new CapitulosDao();

        // insert seriados into database
        capitulosDao.salvaCapitulos(capitulos);
    }


}