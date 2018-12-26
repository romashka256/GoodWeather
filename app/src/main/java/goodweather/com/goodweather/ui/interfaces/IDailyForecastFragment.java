package goodweather.com.goodweather.ui.interfaces;

import com.arellomobile.mvp.MvpView;

import goodweather.com.goodweather.model.models.forecast.DailyForecasts;

public interface IDailyForecastFragment extends MvpView {
    void showForecast(DailyForecasts dailyForecasts);
}
