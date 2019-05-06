package br.cap.sistemas.bibliacelular.activity.model;

import java.util.ArrayList;

public class Model_biblia {
    private String str_nome;
    private ArrayList<Model_livros> livros;

    public Model_biblia() {
    }

    public Model_biblia(String str_nome, ArrayList<Model_livros> livros) {
        this.str_nome = str_nome;
        this.livros = livros;
    }

    public String getStr_nome() {
        return str_nome;
    }

    public void setStr_nome(String str_nome) {
        this.str_nome = str_nome;
    }

    public ArrayList<Model_livros> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Model_livros> livros) {
        this.livros = livros;
    }
}
