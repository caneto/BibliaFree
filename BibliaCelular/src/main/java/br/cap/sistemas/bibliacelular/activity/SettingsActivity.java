package br.cap.sistemas.bibliacelular.activity;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import br.cap.sistemas.bibliacelular.fragment.SettingsFragment;
import br.cap.sistemas.bibliacelular.R;

public class SettingsActivity extends AppCompatActivity {

    private String mSdkInfo = "",mBrand = "", mManufacture = "", mModel = "", mDensity = "", mScreenHightDP = "", mScreenWidthDP = "";
    private static final String TAG = SettingsActivity.class.getSimpleName();
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings_details);
        mActivity = this;
        setupInfos();

     //   getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, new SettingsFragment())
                .commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar bar;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            LinearLayout root = (LinearLayout) findViewById(android.R.id.content).getParent();
            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.activity_settings_toolbar, root, false);
            root.addView(bar, 0);
        } else {
            ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
            ListView content = (ListView) root.getChildAt(0);

            root.removeAllViews();

            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.activity_settings_toolbar, root, false);

            int height;
            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
                height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            }else{
                height = bar.getHeight();
            }

            content.setPadding(0, height, 0, 0);

            root.addView(content);
            root.addView(bar);
        }

        bar.inflateMenu(R.menu.activity_settings);

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.menu_info_display)
                {
                    MaterialDialog materialDialog = new  MaterialDialog.Builder(mActivity)
                            .title("Informações do Dispositivo")
                            .customView(R.layout.dialog_info_display, true)
                            .positiveText(getString(R.string.dialog_receipt_positive_button))
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    //int selectedId = printerRadioGroup.getCheckedRadioButtonId();
                                    dialog.dismiss();
                                }
                            })
                            .build();

                    String infodisplay = "SDK:" + mSdkInfo + "\nMarca:"+mBrand +"\nFabricante:"+mManufacture
                            + "\nModelo:" + mModel + "\nDensidade:" + mDensity
                            + "\nScreen HightDP:" + mScreenHightDP + "\nScreen WidthDP:" + mScreenWidthDP;

                    AppCompatTextView info_display = materialDialog.getCustomView().findViewById(R.id.info_display);
                    info_display.setText(infodisplay);

                    materialDialog.show();
                }

                return false;
            }
        });
    }

    private void setupInfos() {
        mSdkInfo = String.valueOf(Build.VERSION.SDK_INT);
        mBrand   = Build.BRAND.toUpperCase();
        mManufacture = Build.MANUFACTURER.toUpperCase();
        mModel = Build.MODEL;

        Configuration config = getResources().getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mDensity = String.valueOf(config.densityDpi);
        }
        mScreenHightDP = String.valueOf(config.screenHeightDp);
        mScreenWidthDP = String.valueOf(config.screenWidthDp);
    }
}
