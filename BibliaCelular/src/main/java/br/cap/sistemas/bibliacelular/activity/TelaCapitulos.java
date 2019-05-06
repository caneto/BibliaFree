package br.cap.sistemas.bibliacelular.activity;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.cap.sistemas.bibliacelular.BaseActivity;
import br.cap.sistemas.bibliacelular.R;
import br.cap.sistemas.bibliacelular.activity.adapter.CapitulosAdapter;
import br.cap.sistemas.bibliacelular.db.AppDatabase;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulosDao;
import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao;
import io.realm.RealmResults;

public class TelaCapitulos extends BaseActivity {

    private ListView lv_capitulos;

    private AppDatabase mDb;

    private final String TAG = this.getClass().getName();
    private String nome_livro;

    private AppCompatTextView tv_nome_livro,tv_numero_capitulos;
    private BibliaTitulosDao bibliaTitulosDao;
    private CapitulosDao capitulosDao;

    private BibliaTitulos bibliaTitulos;
    private Capitulos capitulos;
    private String numero_capitulos;
    private int idtitulo;
    private String diretorio = "conteudo/";
    private String pasta = "";

    private String TipoBiblia = "";
    private String ParteBiblia = "";

    private CapitulosAdapter capitulosAdaptador;
    private RealmResults<Capitulos> realmCapitulos;
    private ListView capitulosLista;

    @Override
    protected int layoutResource() {
        return R.layout.activity_capitulos;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = super.getIntent();
        nome_livro = (String) intent.getSerializableExtra("nome_livro");

        TipoBiblia = (String) intent.getSerializableExtra("TipoBiblia");
        ParteBiblia = (String) intent.getSerializableExtra("ParteBiblia");
        if(ParteBiblia.equals("Velho Testamento")) {
            diretorio += "VelhoTestamento/";
        } else {
            diretorio += "NovoTestamento/";
        }

        bibliaTitulosDao = new BibliaTitulosDao(); // Inicializa o DAO

        addRegisterControls();

        getContent();
        addContent();

        addListener();

        capitulosDao = new CapitulosDao();
        realmCapitulos = capitulosDao.getCapituloPorIdTitulo(idtitulo);

        capitulosAdaptador = new CapitulosAdapter(realmCapitulos);
        lv_capitulos.setAdapter(capitulosAdaptador);

    }

    public void addRegisterControls() {

        lv_capitulos = (ListView) findViewById(R.id.lv_capitulos);
        tv_nome_livro = (AppCompatTextView) findViewById(R.id.tv_nome_livro);
        tv_numero_capitulos = (AppCompatTextView) findViewById(R.id.tv_numero_capitulos);

    }

    public void addListener() {

        lv_capitulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AppCompatTextView numero_capitulo = view.findViewById(R.id.tv_capitulo);

                String txt_capitulo = numero_capitulo.getText().toString();
                String txt_numero_capitulo = numero_capitulo.getText().toString().replace("Capítulo ","");

                Intent it = new Intent();
                it = new Intent(getApplicationContext(), TelaVizualizadorText.class);

//                if(txt_numero_capitulo.trim().length()==1) txt_numero_capitulo = "0"+txt_numero_capitulo;

                capitulosDao = new CapitulosDao();
                Capitulos capitulos = capitulosDao.getCapituloPorCapitulTexto(txt_capitulo, idtitulo);

                it.putExtra("livro", tv_nome_livro.getText());
                it.putExtra("capitulo", txt_capitulo);
                it.putExtra("texto", diretorio + pasta + "/"+capitulos.getArquivo()+".txt");
                startActivity(it);

  //              Toast.makeText(getApplicationContext(), "Clickei no capitulo : "+txt_numero_capitulo,Toast.LENGTH_SHORT).show();
            }
        });

        //tv_nome_livro.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(getApplication(),TelaVizualizador.class);
        //        intent.putExtra("epub_nome","g1.epub");
        //        startActivity(intent);
  //        }
  //      });

    }

    public void getContent() {

        bibliaTitulos = bibliaTitulosDao.getLivro(nome_livro);
        idtitulo = bibliaTitulos.getId();

        numero_capitulos = bibliaTitulos.getCapitulos();
        pasta = bibliaTitulos.getDiretorio();

        idtitulo = bibliaTitulos.getId();

    }

    public void addContent() {

        tv_nome_livro.setText(nome_livro);
        tv_numero_capitulos.setText(numero_capitulos);
    }

}
