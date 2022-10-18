package br.cap.sistemas.bibliacelular.db.tabelas;

/**
 * Created by cap on 03/12/2017.
 */

public class TbBiblia {

    private Long Id;
    private String Nometitulo;
    private String Livrorigiem;
    private String Categorialivro;
    private String Idioma;
    private String UidCadastro;

    public TbBiblia(){

    }

    public TbBiblia(Long id, String nometitulo, String livroorigem, String categorialivro, String idioma) {
        Id = id;
        Nometitulo = nometitulo;
        Livrorigiem = livroorigem;
        Categorialivro = categorialivro;
        Idioma = idioma;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNometitulo() {
        return Nometitulo;
    }

    public void setNometitulo(String nometitulo) {
        Nometitulo = nometitulo;
    }

    public String getLivrorigiem() {
        return Livrorigiem;
    }

    public void setLivrorigiem(String livrorigiem) {
        Livrorigiem = livrorigiem;
    }

    public String getCategorialivro() {
        return Categorialivro;
    }

    public void setCategorialivro(String categorialivro) {
        Categorialivro = categorialivro;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }

    public String getUidCadastro() {
        return UidCadastro;
    }

    public void setUidCadastro(String uidCadastro) {
        UidCadastro = uidCadastro;
    }
}
