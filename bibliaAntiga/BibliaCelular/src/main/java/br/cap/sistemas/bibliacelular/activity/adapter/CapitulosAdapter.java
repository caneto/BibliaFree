package br.cap.sistemas.bibliacelular.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import br.cap.sistemas.bibliacelular.R;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;
import br.cap.sistemas.bibliacelular.db.tabelas.Capitulos;
import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class CapitulosAdapter extends RealmBaseAdapter<Capitulos> implements ListAdapter {

    private static class ViewHolder {
        TextView tv_capitulo;
        //TextView tv_audio_status;
    }

    public CapitulosAdapter(OrderedRealmCollection<Capitulos> realmResults) {
        super(realmResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.linha_capitulo, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_capitulo = (TextView) convertView.findViewById(R.id.tv_capitulo);
            //viewHolder.tv_audio_status = (TextView) convertView.findViewById(R.id.tv_audio_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (adapterData != null) {
            final Capitulos capitulos = adapterData.get(position);
            viewHolder.tv_capitulo.setText(capitulos.getCapitulo());
            //viewHolder.tv_audio_status.setText(capitulos.getAudio().isEmpty()?"Não":"Sim");
            /*if (inDeletionMode) {
                viewHolder.deleteCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        countersToDelete.add(seriados.getId());
                    }
                });
            } else {
                viewHolder.deleteCheckBox.setOnCheckedChangeListener(null);
            }
            viewHolder.deleteCheckBox.setChecked(countersToDelete.contains(seriados.getId()));
            viewHolder.deleteCheckBox.setVisibility(inDeletionMode ? View.VISIBLE : View.GONE);*/
        }
        return convertView;
    }
}
