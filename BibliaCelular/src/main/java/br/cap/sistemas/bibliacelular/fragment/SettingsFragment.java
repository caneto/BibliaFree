package br.cap.sistemas.bibliacelular.fragment;

import android.os.Bundle;
import androidx.preference.SwitchPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.Preference;

import br.cap.sistemas.bibliacelular.R;
import br.cap.sistemas.bibliacelular.classes.SharedPreferencesUtil;

public class SettingsFragment extends PreferenceFragmentCompat {

    private final String CONFIGURACAO0 = "Configuracao0";
    private final String CONFIGURACAO1 = "Configuracao1";
    private SwitchPreference sp_livroscatolicos, sp_ativamarcacao;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference_layout);

        //Preferences
        sp_livroscatolicos = (SwitchPreference) findPreference(CONFIGURACAO0);
        sp_ativamarcacao = (SwitchPreference) findPreference(CONFIGURACAO1);

        sp_livroscatolicos.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if(sp_livroscatolicos.isChecked()){
                    //Toast.makeText(getActivity(),"Unchecked",Toast.LENGTH_SHORT).show();

                    SharedPreferencesUtil.save(getActivity(), getString(R.string.shared_json_bibliatipo), "E");

                    // Checked the switch programmatically
                    sp_livroscatolicos.setChecked(false);
                }else {
                    //Toast.makeText(getActivity(),"Checked",Toast.LENGTH_SHORT).show();

                    SharedPreferencesUtil.save(getActivity(), getString(R.string.shared_json_bibliatipo), "C");
                    // Unchecked the switch programmatically
                    sp_livroscatolicos.setChecked(true);
                }
                return false;
            }
        });

        sp_ativamarcacao.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if( sp_ativamarcacao.isChecked()){
                    //Toast.makeText(getActivity(),"Unchecked",Toast.LENGTH_SHORT).show();

                    SharedPreferencesUtil.save(getActivity(), getString(R.string.shared_marca_ultimo_lido), "N");

                    // Checked the switch programmatically
                    sp_ativamarcacao.setChecked(false);
                }else {
                    //Toast.makeText(getActivity(),"Checked",Toast.LENGTH_SHORT).show();

                    SharedPreferencesUtil.save(getActivity(), getString(R.string.shared_marca_ultimo_lido), "S");

                    // Unchecked the switch programmatically
                    sp_ativamarcacao.setChecked(true);
                }
                return false;
            }
        });
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        //addPreferencesFromResource(getArguments().getInt(EXTRA_PREFERENCES));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}