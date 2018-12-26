package goodweather.com.goodweather.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.forecast.DailyForecast;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;

public class DailyForecastAdapter extends
                                  RecyclerView.Adapter<DailyForecastAdapter.DailyForecastVH> {

    private DailyForecasts dailyForecasts;
    private Context context;

    public DailyForecastAdapter(DailyForecasts dailyForecasts, Context context) {
        this.dailyForecasts = dailyForecasts;
        this.context = context;
    }

    @NonNull
    @Override
    public DailyForecastVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.daily_forecast_item, viewGroup, false);
        return new DailyForecastVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyForecastVH dailyForecastVH, int i) {
        DailyForecast dailyForecast = dailyForecasts.getDailyForecasts().get(i);
        dailyForecastVH.mMaxDay.setText(dailyForecast.getTemperature().getMaximum().getMaximumTemperaturevalue().toString());
        dailyForecastVH.mMinDay.setText(dailyForecast.getTemperature().getMinimum().getMinimumTemperaturevalue().toString());


        // API возвращало значение на 000 меньше почему-то.
        long datelong= dailyForecast.getEpochDate() * 1000;

        Date date = new Date(datelong);

        SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat mothDayFormat = new SimpleDateFormat("dd MMMM");

        dailyForecastVH.mWeekDay.setText(weekDayFormat.format(date));
        dailyForecastVH.mMonthDay.setText(mothDayFormat.format(date));
    }

    @Override
    public int getItemCount() {
        return dailyForecasts.getDailyForecasts().size();
    }

    public class DailyForecastVH extends RecyclerView.ViewHolder {

        @BindView(R.id.week_day_item)
        TextView mWeekDay;
        @BindView(R.id.month_day_daily_item)
        TextView mMonthDay;
        @BindView(R.id.max_day_daily_item)
        TextView mMaxDay;
        @BindView(R.id.min_day_daily_item)
        TextView mMinDay;
        @BindView(R.id.image_daily_item)
        ImageView mDailyImage;

        public DailyForecastVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
