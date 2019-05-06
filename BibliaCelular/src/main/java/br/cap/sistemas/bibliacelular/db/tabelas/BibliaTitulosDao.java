package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.IOException;

public class BibliaTitulosDao {

    public BibliaTitulos getBibliaTituloPorId(String Id) {
        Realm realm = Realm.getDefaultInstance();

        try {
            BibliaTitulos seriados = realm.where(BibliaTitulos.class)
                    .beginsWith("id", Id).findFirst();

            // Check if the data is not null, if null there is no user with these Id
            if (seriados == null) {
                return null;
            }

            return seriados;

        } catch (Exception e) {
            // print the error
            e.printStackTrace();

        }

        return null;
    }

    public RealmResults<BibliaTitulos> getAll() {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<BibliaTitulos> results = realm.where(BibliaTitulos.class)
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

    public RealmResults<BibliaTitulos> getAllLivro(String Livro) {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<BibliaTitulos> results = realm.where(BibliaTitulos.class)
                    .beginsWith("livro", Livro)
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


    public BibliaTitulos getLivro(String titulo) {
        Realm realm = Realm.getDefaultInstance();
        try {
            BibliaTitulos results = realm.where(BibliaTitulos.class)
                    .beginsWith("nometitulo", titulo)
                    .findFirst();

            if (results == null) {
                return null;
            }

            return results;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void salvaBiblia(BibliaTitulos biblia) {
        saveOrUpdate(biblia);
    }

    protected void saveOrUpdate(BibliaTitulos biblia) {
        Realm realm = Realm.getDefaultInstance();
        try {
            //save ususario on realm
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(biblia);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delAll() {
        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction(); // open a transation
            realm.delete(BibliaTitulos.class); // delete the data
            realm.commitTransaction(); // close the transation

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

}