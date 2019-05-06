package br.cap.sistemas.bibliacelular.activity.model;

import java.util.ArrayList;

public class Model_biblia_capitulos {
    private String str_nome;
    private ArrayList<Model_livros_capitulos> livros_capitulos;

    public Model_biblia_capitulos() {
    }

    public Model_biblia_capitulos(String str_nome, ArrayList<Model_livros_capitulos> livros_capitulos) {
        this.str_nome = str_nome;
        this.livros_capitulos = livros_capitulos;
    }

    public String getStr_nome() {
        return str_nome;
    }

    public void setStr_nome(String str_nome) {
        this.str_nome = str_nome;
    }

    public ArrayList<Model_livros_capitulos> getLivrosCapitulos() {
        return livros_capitulos;
    }

    public void setLivrosCapitulos(ArrayList<Model_livros_capitulos> livros_capitulos) {
        this.livros_capitulos = livros_capitulos;
    }
}
