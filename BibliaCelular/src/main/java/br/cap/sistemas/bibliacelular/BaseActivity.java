package br.cap.sistemas.bibliacelular;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kila.apprater_dialog.lars.AppRater;

import java.text.NumberFormat;
import java.util.Locale;

import br.cap.sistemas.bibliacelular.activity.SobreActivity;
import br.cap.sistemas.bibliacelular.activity.TelaVizualizadorDicionarioBiblico;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = this.getClass().getName();
    public static String AppName, PackageName, VersionCode, VersionName;
    public static final Locale brasil = new Locale("pt", "BR");
    public static NumberFormat nf = NumberFormat.getCurrencyInstance(brasil);

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    public static View header;


    private FragmentManager fragmentManager;

    protected abstract
    @LayoutRes
    int layoutResource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.packinfo();
        this.setContentView(layoutResource());
        this.setupToolbar();
        this.setaref();
        this.setaDraw();

        fragmentManager = getSupportFragmentManager();

    }

    public String getApplicationName() {
        int stringId = getApplicationInfo().labelRes;
        return getString(stringId);
    }

    public void setaref() {

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    protected void enterFromBottomAnimation() {
        overridePendingTransition(R.anim.activity_open_translate_from_bottom, R.anim.activity_no_animation);
    }

    protected void exitToBottomAnimation() {
        overridePendingTransition(R.anim.activity_no_animation, R.anim.activity_close_translate_to_bottom);
    }

    private void packinfo() {

        PackageInfo pinfo = null;

        try {
            pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        AppName = pinfo.applicationInfo.loadLabel(getPackageManager()).toString();
        PackageName = pinfo.packageName;
        VersionCode = String.valueOf(pinfo.versionCode);
        VersionName = pinfo.versionName;

    }

    private void setupToolbar() {

       toolbar = findViewById(R.id.toolbar);

       if (toolbar == null) {
            return;
       }

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setaDraw() {

        if (drawer == null) {
            return;
        }
        // Show a dialog if meets conditions
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

    }

    static public void toastRapido(String msg, Activity act) {
        Toast.makeText(act, msg, Toast.LENGTH_SHORT).show();
    }

    static public void toastDemoradoo(String msg, Activity act) {
        Toast.makeText(act, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Will replace de current Fragment on the layout
     *
     * @Param fragment The fragment to show/replace.
     */
    public final void replaceFragment(Fragment fragment, String tag) {
        if (fragment != null) {
            //String tag = fragment.getTag() != null && !fragment.getTag().isEmpty() ? fragment.getTag() : fragment.getClass().getSimpleName();
            fragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.content_frame, fragment, tag)
                    .commitAllowingStateLoss();
            //.commit();

        }
    }

    public final void showFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .show(fragment)
                    .commit();

        }
    }

    public static void startActivity(Context context, Class<? extends Activity> activityClass) {

        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

//            startActivity(getApplication(), SettingsActivity.class);
            // Display the fragment as the main content.
            //getSupportFragmentManager().beginTransaction()
            //        .replace(android.R.id.content, new TelaPreference())
            //        .commit();
            Intent intent = new Intent();
            intent.setClassName(this, "br.cap.sistemas.bibliacelular.activity.SettingsActivity");
            startActivity(intent);

            return true;
        }

        if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ///if (id == R.id.novo_testamento) {
            // Handle the camera action
        //} else if (id == R.id.velho_testamento) {

        if (id == R.id.oracao_pai_nosso) {
            Intent intent = new Intent();
            intent.setClassName(this, "br.cap.sistemas.bibliacelular.activity.TelaVizualizadorPaiNosso");
            startActivity(intent);

       // } else if (id == R.id.salmo_de_hoje) {

        } else if (id == R.id.nav_about) {
            // } else if (id == R.id.nav_share) {
            Intent it = new Intent();
            it = new Intent(getApplicationContext(), SobreActivity.class);
            startActivity(it);

        } else if (id == R.id.nav_dicionario) {
            // } else if (id == R.id.nav_share) {
            Intent it = new Intent();
            it = new Intent(getApplicationContext(), TelaVizualizadorDicionarioBiblico.class);
            startActivity(it);
            // } else if (id == R.id.nav_send) {
        } else if (id == R.id.action_config) {
            Intent intent = new Intent();
            intent.setClassName(this, "br.cap.sistemas.bibliacelular.activity.SettingsActivity");
            startActivity(intent);

        } else if (id == R.id.action_exit) {
            finish();
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
