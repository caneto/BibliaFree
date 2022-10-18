package br.cap.sistemas.bibliacelular.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import br.cap.sistemas.bibliacelular.R;
import br.cap.sistemas.bibliacelular.db.tabelas.BibliaTitulos;
import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class BibliaTitulosAdapter extends RealmBaseAdapter<BibliaTitulos> implements ListAdapter {

    private static class ViewHolder {
        TextView nomelivro;
        TextView capitulos;
    }

    public BibliaTitulosAdapter(OrderedRealmCollection<BibliaTitulos> realmResults) {
        super(realmResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.linha_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nomelivro = (TextView) convertView.findViewById(R.id.tv_nome_livro);
            viewHolder.capitulos = (TextView) convertView.findViewById(R.id.tv_capitulos_numero);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (adapterData != null) {
            final BibliaTitulos bibliaTitulos= adapterData.get(position);
            viewHolder.nomelivro.setText(bibliaTitulos.getNometitulo());
            viewHolder.capitulos.setText(bibliaTitulos.getCapitulos());
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
