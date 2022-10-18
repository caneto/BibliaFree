package br.cap.sistemas.bibliacelular.activity.model;

public class Model_livros {
    private String str_titulo;
    private String str_capitulos;
    private String str_id;

    public Model_livros() {

    }

    public Model_livros(String str_titulo, String str_capitulos, String str_id) {
        this.str_titulo = str_titulo;
        this.str_capitulos = str_capitulos;
        this.str_id = str_id;
    }

    public String getStr_titulo() {
        return str_titulo;
    }

    public void setStr_titulo(String str_titulo) {
        this.str_titulo = str_titulo;
    }

    public String getStr_capitulos() {
        return str_capitulos;
    }

    public void setStr_capitulos(String str_capitulos) {
        this.str_capitulos = str_capitulos;
    }

    public String getStr_id() {
        return str_id;
    }

    public void setStr_id(String str_id) {
        this.str_id = str_id;
    }



}
