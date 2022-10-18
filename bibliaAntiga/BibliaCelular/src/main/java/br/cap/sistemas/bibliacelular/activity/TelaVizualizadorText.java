package br.cap.sistemas.bibliacelular.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import br.cap.sistemas.bibliacelular.BaseActivity;
import br.cap.sistemas.bibliacelular.R;

public class TelaVizualizadorText extends BaseActivity {

    private final String TAG = this.getClass().getName();
    private String texto, livro, capitulo;
    private TextView mostraTexto, tvInfo;

    @Override
    protected int layoutResource() {
        return R.layout.mostratexto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "Iniciando Modulo Mostra Texto!");

        Intent intent = super.getIntent();
        this.texto = ((String) intent.getSerializableExtra("texto"));
        this.livro = ((String) intent.getSerializableExtra("livro"));
        this.capitulo = ((String) intent.getSerializableExtra("capitulo"));

        AssetManager assetManager = getAssets();

        mostraTexto = (TextView) findViewById(R.id.txtMostraTexto);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        //	                + files[0]);
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(this.texto);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        String s = readTextFile(inputStream);

        mostraTexto.setText(s);
        tvInfo.setText("Biblia - " + livro + " - " + capitulo);

    }

    /**
     * This method reads simple text file
     * @param inputStream
     * @return data from file
     */
    private String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        try
        {
            while ((len = inputStream.read(buf)) != -1)
            {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
        }
        return outputStream.toString();
    }
}
