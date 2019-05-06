package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BibliaTitulos extends RealmObject {

    @PrimaryKey
    @NonNull
    private int id;
    private String nometitulo;
    private String capitulos;
    private String livro;
    private String idioma;
    private String tipo_biblia;
    private String diretorio;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNometitulo() {
        return nometitulo;
    }

    public void setNometitulo(String nometitulo) {
        this.nometitulo = nometitulo;
    }

    public String getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(String capitulos) {
        this.capitulos = capitulos;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipo_biblia() {
        return tipo_biblia;
    }

    public void setTipo_biblia(String tipo_biblia) {
        this.tipo_biblia = tipo_biblia;
    }


    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

}
