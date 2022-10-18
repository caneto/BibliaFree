package br.cap.sistemas.bibliacelular.db.dados;

import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao;

public class dados_velhotestamento {

    public static Integer Rotinas(int idContador) {

        int id_contador = 1;

        for (int i = 1; i <= 50; i++) { // Genesis

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(1);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Gn "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 40; i++) { // Exodo

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(2);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ex "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 27; i++) { // Levitico

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(3);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Lv "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 36; i++) { // Numeros

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(4);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Nm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 34; i++) { // Deuteronomio

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(5);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Dt "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 24; i++) { // Josue

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(6);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Js "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 21; i++) { // Josue

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(7);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jz "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Josue

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(8);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Rt "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 31; i++) { // I Samuel

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(9);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Sm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 24; i++) { // II Samuel

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(10);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Sm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 22; i++) { // I Reis

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(11);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Rs "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 25; i++) { // II Reis

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(12);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Rs "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 29; i++) { // I Cronicas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(13);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Cr "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 36; i++) { // II Cronicas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(14);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Cr "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 10; i++) { // Esdras

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(15);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ed "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 13; i++) { // Neemias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(16);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ne "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 14; i++) { // Tobias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(17);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Tb "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 16; i++) { // Judite

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(18);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jd "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 10; i++) { // Ester

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(19);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Et "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 42; i++) { // Jo

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(20);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Joh "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 150; i++) { // Salmos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(21);
            capitulos.setCapitulo(String.format("%03d", i)+" - Capitulo");
            capitulos.setArquivo("Sl "+String.format("%03d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 16; i++) { // I Macabeus

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(22);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("I Mc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 15; i++) { // II Macabeus

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(23);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("II Mc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 31; i++) { // Proverbios

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(24);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Pv "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 12; i++) { // Eclesiastes

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(25);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ec "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 8; i++) { // Cantico dos Canticos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(26);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ct "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 19; i++) { // Sabedoria

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(27);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Sb "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 51; i++) { // Eclesiatico

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(28);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Eclo "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 66; i++) { // Isaias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(29);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Is "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 52; i++) { // Jeremias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(30);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Je "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 5; i++) { // Lamentacoes

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(31);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Lm "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 6; i++) { // Baruc

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(32);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Br "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 48; i++) { // Ezequiel

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(33);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ez "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 14; i++) { // Daniel

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(34);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Dn "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 14; i++) { // Oseias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(35);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Os "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Joel

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(36);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jl "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 9; i++) { // Amos

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(37);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Am "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 1; i++) { // Obadias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(38);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ab "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Jonas

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(39);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Jn "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 7; i++) { // Miqueias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(40);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Mq "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // Naum

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(41);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Na "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // Habacuque

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(42);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Hc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 3; i++) { // Safonias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(43);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Sf "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 2; i++) { // Ageu

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(44);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ag "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 14; i++) { // Zacarias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(45);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Zc "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        for (int i = 1; i <= 4; i++) { // Malaquias

            Capitulos capitulos = new Capitulos();
            capitulos.setId(id_contador);
            capitulos.setId_titulo(46);
            capitulos.setCapitulo(String.format("%02d", i)+" - Capitulo");
            capitulos.setArquivo("Ml "+String.format("%02d", i));
            capitulos.setAudio("");

            CapitulosDao.gravaCapitulosDB(capitulos);
            id_contador++;
        }

        // Fim do Velho testamento

        return id_contador;

    }

}
