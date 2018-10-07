package elle0827.io.l4s_sns_apps_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    private List<Country> mcountries;

    public CountryAdapter(Context context, int layoutResourceId, List<Country> objects) {
        super(context, layoutResourceId, objects);

        mcountries = objects;

    }

    @Override
    public int getCount() {
        return mcountries.size();
    }
//    ニュース（要素数）が何個あるか

    @Override
    public Country getItem(int position) {
        return mcountries.get(position);
    }

    //なんばん目のニュース（要素）か
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final CountryAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country, parent, false);
            viewHolder = new CountryAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CountryAdapter.ViewHolder) convertView.getTag();

        }
        final Country item = getItem(position);
        if (item != null) {
            viewHolder.cityname.setText(item.getName());
        }

        return convertView;
    }


    public static class ViewHolder {
        ImageView pin;
        TextView cityname;

        public ViewHolder(View view) {
            pin = (ImageView) view.findViewById(R.id.pin);
            cityname= (TextView) view.findViewById(R.id.cityname);
        }
    }
}

