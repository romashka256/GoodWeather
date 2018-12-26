package goodweather.com.goodweather.presenter.listeners;

import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;

public interface On12HourForecastLoadedListener {
    void On12HourForecastLoaded(HourlyForecast hourlyForecast);
}
