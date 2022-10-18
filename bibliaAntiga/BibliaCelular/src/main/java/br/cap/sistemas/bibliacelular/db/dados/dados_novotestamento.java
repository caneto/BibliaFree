package br.cap.sistemas.bibliacelular.db.dados;

import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao;

public class dados_novotestamento {

    public static Integer Rotinas(int idContador) {

        int id_contador = idContador;

        // Inicio do Novo Testamento

        for (int i = 1; i <= 28; i++) { // Mateus

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(47);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Mt "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 16; i++) { // Marcos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(48);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Mc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 24; i++) { // Lucas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(49);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Lc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 21; i++) { // Joao

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(50);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jo "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 28; i++) { // Atos dos Apostolos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(51);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("At "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 16; i++) { // Romanos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(52);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Rm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 16; i++) { // I Corintos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(53);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Cor "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 13; i++) { // II Corintos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(54);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Cor "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 6; i++) { // Galatas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(55);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Gl "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 24; i++) { // Efesios

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(56);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ef "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Filipenses

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(57);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Fl "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Colossenses

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(58);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Cl "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 5; i++) { // I Tessalonicenses

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(59);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Ts "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // II Tessalonicenses

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(60);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Ts "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 6; i++) { // I Timoteo

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(61);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Tm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // II Timoteo

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(62);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Ts "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // Tito

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(63);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Tt "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 1; i++) { // Filemom

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(64);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Fm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 13; i++) { // Hebreus

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(65);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Hb "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 5; i++) { // Tiago

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(66);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Tg "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 5; i++) { // I Pedro

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(67);
            capitulos.setCapitulo(String.format("%03d", i)+" - Capitulo");
            capitulos.setArquivo("I Pe "+String.format("%03d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // II Pedro

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(68);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Pe "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 5; i++) { // I Joao

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(69);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Jo "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 1; i++) { // II Joao

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(70);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Jo "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 1; i++) { // III Joao

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(71);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("III Jo "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 1; i++) { // Judas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(72);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jd "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 22; i++) { // Apocalipse

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(73);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ap "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        // Fim do Novo testamento

        return id_contador;
    }

}
