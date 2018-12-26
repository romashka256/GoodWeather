package goodweather.com.goodweather.model;

import java.util.List;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.Constants;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.model.api.HourForecastAPI;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class HourForecastService {
    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public HourForecastService() {
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        retrofit = App.getsAppComponent().getRetrofit();
    }

    public Observable<List<HourlyForecast>> get12HourForecast(String locationkey) {
        return retrofit.create(HourForecastAPI.class).get12HoursForecast(locationkey, Constants.APIKEY, Constants.LANGUAGE, "true", "true");
    }
}
