package br.cap.sistemas.bibliacelular.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import br.cap.sistemas.bibliacelular.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

import static br.cap.sistemas.bibliacelular.BaseActivity.VersionName;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String documento = "Estou disponiblizando a Biblia Completa com todos os Livros.";

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.mipmap.ic_launcher)
                .setDescription(documento)
                .addItem(new Element().setTitle("Versão "+ VersionName))
                //.addItem(adsElement)
                .addGroup("Contatos")
                .addEmail("cacpnrj@gmail.com")
                .addWebsite("http://caneto.github.io/")
                .addFacebook("capsistemas")
                .addTwitter("caneto")
                //.addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("br.cap.sistemas.bibliacelular")
                //.addInstagram("medyo80")
                .addGitHub("caneto")
                //.addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
        //setContentView(R.layout.activity_sobre);
    }
}
