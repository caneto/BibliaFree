package  br.cap.sistemas.bibliacelular.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import br.cap.sistemas.bibliacelular.activity.model.Model_biblia_capitulos;
import br.cap.sistemas.bibliacelular.activity.model.Model_livros_capitulos;
import br.cap.sistemas.bibliacelular.classes.SharedPreferencesUtil;
import br.cap.sistemas.bibliacelular.db.dados.dados_novotestamento;
import br.cap.sistemas.bibliacelular.db.dados.dados_velhotestamento;
import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao;

import lib.kingja.switchbutton.SwitchMultiButton;

import br.cap.sistemas.bibliacelular.BaseActivity;
import br.cap.sistemas.bibliacelular.R;
import br.cap.sistemas.bibliacelular.activity.adapter.BibliaTitulosAdapter;
import br.cap.sistemas.bibliacelular.activity.model.Model_biblia;
import br.cap.sistemas.bibliacelular.activity.model.Model_livros;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulosDao;

import io.realm.RealmResults;

import static br.cap.sistemas.bibliacelular.db.tabelas.CapitulosDao.gravaCapitulosDB;

public class TelaPrincipal extends BaseActivity  {

    private final String TAG = this.getClass().getName();

    private SwitchMultiButton mSwitchMultiButton;

    private ProgressBar mProgressBar;
    private RelativeLayout rl_layout;

    private ArrayList<Model_biblia> biblia = new ArrayList<>();
    private ArrayList<Model_biblia_capitulos> biblia_capitulos = new ArrayList<>();

    private BibliaTitulosAdapter bibliaTitulosAdaptador;
    private RealmResults<BibliaTitulos> realmBibliaTitulo;
    private ListView bibliaLista;

    private String TipoBiblia = "";
    private String MarcaUltimoLido = "";
    private String ParteBiblia = "Velho Testamento";

    private boolean jsonlido = false;

    private static final int REQUEST_CODE = 1;

    private BibliaTitulosDao bibliaTitulosDao;

    @Override
    protected int layoutResource() {
        return R.layout.activity_principal;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TipoBiblia = SharedPreferencesUtil.get(this, this.getString(R.string.shared_json_bibliatipo));
        MarcaUltimoLido = SharedPreferencesUtil.get(this, this.getString(R.string.shared_marca_ultimo_lido));

        if(TipoBiblia != "") SharedPreferencesUtil.save(this,this.getString(R.string.shared_json_bibliatipo),"E");
        if(MarcaUltimoLido != "") SharedPreferencesUtil.save(this,this.getString(R.string.shared_marca_ultimo_lido),"N");

        addRegisterControls();

        jsonlido = SharedPreferencesUtil.getBoolean(this, this.getString(R.string.shared_json_lido));

        if(!jsonlido) {  // só carrega na primeira vez.

            carrega_data_titulo();// Carrega dados (titulos)
            //carrega_data_capitulo(); // Carrega dados (capitulos)
            carrega_data_capitulo_dinamico();
            SharedPreferencesUtil.save(this, this.getString(R.string.shared_json_lido), String.valueOf(true));
        }


        addListener();
        //setSeriadosListener();

        bibliaTitulosDao = new BibliaTitulosDao();
        realmBibliaTitulo = bibliaTitulosDao.getAllLivro("Velho Testamento");

        bibliaTitulosAdaptador = new BibliaTitulosAdapter(realmBibliaTitulo);
        bibliaLista.setAdapter(bibliaTitulosAdaptador);

    }

    @Override
    public void onResume() {
        super.onResume();

    }


    public void addRegisterControls() {

        bibliaLista = (ListView) findViewById(R.id.lv_biblia);

        rl_layout = (RelativeLayout) findViewById(R.id.rl_layout);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mSwitchMultiButton = (SwitchMultiButton) findViewById(R.id.tabs_layout);
    }

    public void addListener() {


        mSwitchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                ParteBiblia = tabText;
                realmBibliaTitulo = bibliaTitulosDao.getAllLivro(tabText);
                bibliaTitulosAdaptador = new BibliaTitulosAdapter(realmBibliaTitulo);
                bibliaLista.setAdapter(bibliaTitulosAdaptador);
                bibliaTitulosAdaptador.notifyDataSetChanged();
            }
        });

        bibliaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView nome_livro = view.findViewById(R.id.tv_nome_livro);
                String txt_nome_livro = nome_livro.getText().toString();

                Intent intcap = new Intent(TelaPrincipal.this,TelaCapitulos.class);
                intcap.putExtra("nome_livro", txt_nome_livro);
                intcap.putExtra("TipoBiblia", TipoBiblia);
                intcap.putExtra("ParteBiblia",ParteBiblia);
                startActivity(intcap);

                //Toast.makeText(getApplicationContext(), "Clickei na linha : "+txt_nome_livro,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();

        }
    }

    private void exibirProgress(boolean exibir) {
        mProgressBar.setVisibility(exibir ? View.VISIBLE : View.GONE);
    }

    private void exibirRlLayout(boolean exibir) {
        rl_layout.setVisibility(exibir ? View.VISIBLE : View.GONE);
    }

    public String loadJSONFromAsset(String arquivo) {
        String json = null;
        try {

            InputStream is = getAssets().open(arquivo);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e(TAG, "Json response " + json);
        return json;

    }

    private void carrega_data_titulo() {

        exibirProgress(true);
        exibirRlLayout(false);

        final BibliaTitulosDao bibliaTitulosDao = new BibliaTitulosDao();
        bibliaTitulosDao.delAll();

        String str_data = loadJSONFromAsset("titulos.json");   // Carrega o Json com os titulos dos Livros da Biblia

        try {
            JSONObject jsonObject_biblia = new JSONObject(str_data);
            JSONArray jsonArray_biblia = jsonObject_biblia.getJSONArray("biblia");
            biblia = new ArrayList<>();
            for (int i = 0; i < jsonArray_biblia.length(); i++) {
                Model_biblia obj_biblia = new Model_biblia();
                JSONObject jsonObject = jsonArray_biblia.getJSONObject(i);
                JSONArray jsonArray_titulos = jsonObject.getJSONArray("titulos");
                ArrayList<Model_livros> livros = new ArrayList<>();
                for (int j = 0; j < jsonArray_titulos.length(); j++) {

                     JSONObject jsonObject_titulos = jsonArray_titulos.getJSONObject(j);
            //        Model_livros obj_titulo = new Model_livros();
            //        obj_titulo.setStr_titulo(jsonObject_titulos.getString("titulo"));
            //        obj_titulo.setStr_capitulos(jsonObject_titulos.getString("capitulos"));
            //        obj_titulo.setStr_id(jsonObject_titulos.getString("id"));
            //        livros.add(obj_titulo);

                    BibliaTitulos bibliaTitulos = new BibliaTitulos();
                    bibliaTitulos.setId(Integer.valueOf(jsonObject_titulos.getString("id")));
                    bibliaTitulos.setNometitulo(jsonObject_titulos.getString("titulo"));
                    bibliaTitulos.setCapitulos(jsonObject_titulos.getString("capitulos"));
                    bibliaTitulos.setTipo_biblia(jsonObject_titulos.getString("livro")); // Livro tipo de Biblia C (Catolica) T (Commum)
                    bibliaTitulos.setDiretorio(jsonObject_titulos.getString("diretorio")); // Diretorio do Livro..
                    bibliaTitulos.setIdioma("portugues");
                    bibliaTitulos.setLivro(jsonObject.getString("nome"));

                    gravaBibliaDB(bibliaTitulos);

                }

                obj_biblia.setLivros(livros);
                obj_biblia.setStr_nome(jsonObject.getString("nome"));

                biblia.add(obj_biblia);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        exibirProgress(false);
        exibirRlLayout(true);

    }

    private void carrega_data_capitulo() {

        exibirProgress(true);
        exibirRlLayout(false);

        final CapitulosDao CapitulosDao = new CapitulosDao();
        CapitulosDao.delAll();

        String str_data = loadJSONFromAsset("capitulos.json");   // Carrega o Json com os titulos dos Livros da Biblia

        try {
            JSONObject jsonObject_biblia_capitulos = new JSONObject(str_data);
            JSONArray jsonArray_biblia_capitulos = jsonObject_biblia_capitulos.getJSONArray("biblia");
            biblia_capitulos = new ArrayList<>();
            for (int i = 0; i < jsonArray_biblia_capitulos.length(); i++) {
                Model_biblia_capitulos obj_biblia_capitulos = new Model_biblia_capitulos();
                JSONObject jsonObject_capitulos = jsonArray_biblia_capitulos.getJSONObject(i);
                JSONArray jsonArray_capitulos = jsonObject_capitulos.getJSONArray("capitulos");
                ArrayList<Model_livros_capitulos> livros_capitulos = new ArrayList<>();
                for (int j = 0; j < jsonArray_capitulos.length(); j++) {

                    JSONObject jsonObject_capitulos_item = jsonArray_capitulos.getJSONObject(j);
            //        Model_livros_capitulos obj_capitulo = new Model_livros_capitulos();
            //        obj_capitulo.setStr_capitulo(jsonObject_capitulos_item.getString("capitulo"));
            //        obj_capitulo.setStr_nome_arquivo(jsonObject_capitulos_item.getString("nome_arquivo"));
            //        obj_capitulo.setStr_id_titulo(jsonObject_capitulos_item.getString("id_titulo"));
            //        obj_capitulo.setStr_audio_arquivo(jsonObject_capitulos_item.getString("audio_arquivo"));
            //        obj_capitulo.setStr_id(jsonObject_capitulos_item.getString("id"));
            //        livros_capitulos.add(obj_capitulo);

                    Capitulos capitulos = new Capitulos();
                    capitulos.setId(Integer.valueOf(jsonObject_capitulos_item.getString("id")));
                    capitulos.setId_titulo(Integer.valueOf(jsonObject_capitulos_item.getString("id_titulo")));
                    capitulos.setCapitulo(jsonObject_capitulos_item.getString("capitulo"));
                    capitulos.setArquivo(jsonObject_capitulos_item.getString("nome_arquivo"));
                    capitulos.setAudio(jsonObject_capitulos_item.getString("audio_arquivo"));

                    gravaCapitulosDB(capitulos);

                }

                obj_biblia_capitulos.setLivrosCapitulos(livros_capitulos);
                obj_biblia_capitulos.setStr_nome(jsonObject_capitulos.getString("nome"));

                biblia_capitulos.add(obj_biblia_capitulos);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        exibirProgress(false);
        exibirRlLayout(true);

    }

    private void carrega_data_capitulo_dinamico() {

        exibirProgress(true);
        exibirRlLayout(false);

        final CapitulosDao CapitulosDao = new CapitulosDao();
        CapitulosDao.delAll();

        try {

            // Inicio do Velho Testamento


            int idContador = dados_velhotestamento.Rotinas(0);
            idContador = dados_novotestamento.Rotinas(idContador);

            // Inicio Novo Testamento


        } catch (Exception e) {
            e.printStackTrace();
        }

        exibirProgress(false);
        exibirRlLayout(true);

    }



    private void gravaBibliaDB (BibliaTitulos bibliaTitulos) {

        BibliaTitulosDao bibliaTitulosDao  = new BibliaTitulosDao();

        // insert seriados into database
        bibliaTitulosDao.salvaBiblia(bibliaTitulos);
    }



}

