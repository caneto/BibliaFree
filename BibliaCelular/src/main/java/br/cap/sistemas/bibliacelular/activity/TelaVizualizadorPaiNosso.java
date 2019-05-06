package br.cap.sistemas.bibliacelular.activity;

import android.os.Bundle;
import android.util.Log;

import br.cap.sistemas.bibliacelular.BaseActivity;
import br.cap.sistemas.bibliacelular.R;

public class TelaVizualizadorPaiNosso extends BaseActivity {

    private final String TAG = this.getClass().getName();

    @Override
    protected int layoutResource() {
        return R.layout.mostratextopainosso;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "Iniciando Modulo Mostra Texto!");

    }

}
