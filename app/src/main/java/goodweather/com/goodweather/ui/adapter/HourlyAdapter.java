package goodweather.com.goodweather.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyVH> {

    List<HourlyForecast> hourlyForecasts;
    Context context;

    public HourlyAdapter(List<HourlyForecast> hourlyForecasts, Context context) {
        this.hourlyForecasts = hourlyForecasts;
        this.context = context;
    }

    @NonNull
    @Override
    public HourlyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.hourly_forecast_item, null,false);


        return new HourlyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyVH hourlyVH, int i) {

        HourlyForecast hourlyForecast = hourlyForecasts.get(i);

        Date date = new Date((hourlyForecast.getEpochDateTime() * 1000));

        hourlyVH.mTemp.setText(hourlyForecast.getTemperature().getRealFeelTemperaturevalue().toString());
        hourlyVH.mTime.setText(new SimpleDateFormat("hh:mm").format(date));

    }

    @Override
    public int getItemCount() {
        return hourlyForecasts.size();
    }

    public class HourlyVH extends RecyclerView.ViewHolder {
        @BindView(R.id.hourly_forecast_item_temp)
        TextView mTemp;
        @BindView(R.id.hourly_forecast_item_time)
        TextView mTime;

        public HourlyVH(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
