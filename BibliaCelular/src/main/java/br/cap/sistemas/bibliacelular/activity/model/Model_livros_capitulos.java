package br.cap.sistemas.bibliacelular.activity.model;

public class Model_livros_capitulos {
    private String str_id;
    private String str_id_titulo;
    private String str_capitulo;
    private String str_nome_arquivo;
    private String str_audio_arquivo;

    public Model_livros_capitulos() {

    }

    public Model_livros_capitulos(String str_nome_arquivo, String str_capitulo, String str_id_titulo, String str_id) {
        this.str_capitulo = str_capitulo;
        this.str_nome_arquivo = str_nome_arquivo;
        this.str_id = str_id;
        this.str_id_titulo = str_id_titulo;
    }

    public String getStr_capitulo() {
        return str_capitulo;
    }

    public void setStr_capitulo(String str_capitulo) {
        this.str_capitulo = str_capitulo;
    }

    public String getStr_nome_arquivo() {
        return str_nome_arquivo;
    }

    public void setStr_nome_arquivo(String str_nome_arquivo) {
        this.str_nome_arquivo = str_nome_arquivo;
    }

    public String getStr_id() {
        return str_id;
    }

    public void setStr_id(String str_id) {
        this.str_id = str_id;
    }

    public String getStr_id_titulo() {
        return str_id_titulo;
    }

    public void setStr_id_titulo(String str_id_titulo) {
        this.str_id_titulo = str_id_titulo;
    }


    public String getStr_audio_arquivo() {
        return str_audio_arquivo;
    }

    public void setStr_audio_arquivo(String str_audio_arquivo) {
        this.str_audio_arquivo = str_audio_arquivo;
    }

}
