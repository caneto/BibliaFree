package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 20/09/2022
 */

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bibliatitulos")
public class BibliaTitulos {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nometitulo")
    private String nometitulo;
    @ColumnInfo(name = "capitulos")
    private String capitulos;
    @ColumnInfo(name = "livro")
    private String livro;
    @ColumnInfo(name = "idioma")
    private String idioma;
    @ColumnInfo(name = "tipo_biblia")
    private String tipo_biblia;
    @ColumnInfo(name = "diretorio")
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
