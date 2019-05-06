package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

import android.support.annotation.NonNull;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Capitulos extends RealmObject {

    @PrimaryKey
    @NonNull
    private int id;
    private int id_titulo;
    private String capitulo;
    private String arquivo;
    private String audio;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public int getId_titulo() {
        return id_titulo;
    }

    public void setId_titulo(int id_titulo) {
        this.id_titulo = id_titulo;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

}
