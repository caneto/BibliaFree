package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "capitulos")
public class Capitulos {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "id_titulo")
    private int id_titulo;
    @ColumnInfo(name = "capitulo")
    private String capitulo;
    @ColumnInfo(name = "arquivo")
    private String arquivo;
    @ColumnInfo(name = "audio")
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
