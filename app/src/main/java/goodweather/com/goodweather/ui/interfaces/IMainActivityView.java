package goodweather.com.goodweather.ui.interfaces;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import goodweather.com.goodweather.model.models.Location;
import goodweather.com.goodweather.model.models.city.City;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;

public interface IMainActivityView extends MvpView {
    void showCity(Location location);
    void showDailyForecastData(DailyForecasts dailyForecast);
    void showResult(List<City> cities);
    void showCurrentConditions(CurentContiditions curentContiditions);
    void showLoading();
    void hideLoading();
    void showHourlyForcast(List<HourlyForecast> hourlyForecasts);
}
