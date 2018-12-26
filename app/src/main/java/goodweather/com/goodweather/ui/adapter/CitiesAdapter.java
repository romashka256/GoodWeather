package goodweather.com.goodweather.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.city.City;
import goodweather.com.goodweather.ui.interfaces.OnCityClickedListener;
import lombok.Getter;
import lombok.Setter;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesVH> {

    @Setter
    @Getter
    private List<City> cities;

    private Context context;
    private OnCityClickedListener onCityClickedListener;

    public CitiesAdapter(Context context, OnCityClickedListener onCityClickedListener) {
        cities = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public CitiesVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_item, viewGroup, false);
        return new CitiesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesVH citiesVH, int i) {
        citiesVH.mCityName.setText(cities.get(i).getCityName());
        citiesVH.mCountryName.setText(cities.get(i).getCountry().getCountryName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CitiesVH extends RecyclerView.ViewHolder {
        @BindView(R.id.cities_item_cityname)
        TextView mCityName;
        @BindView(R.id.cities_item_countryname)
        TextView mCountryName;

        public CitiesVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(v -> onCityClickedListener.onCityClicked(cities.get(getAdapterPosition())));
        }
    }
}
