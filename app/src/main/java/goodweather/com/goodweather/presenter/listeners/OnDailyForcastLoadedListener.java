package goodweather.com.goodweather.presenter.listeners;

import goodweather.com.goodweather.model.models.forecast.DailyForecasts;

public interface OnDailyForcastLoadedListener {
    void OnDailyForecastLoaded(DailyForecasts dailyForecast);
}
