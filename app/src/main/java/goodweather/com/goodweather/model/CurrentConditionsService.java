package goodweather.com.goodweather.model;

import java.util.List;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.Constants;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.model.api.CurrentConditionsAPI;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CurrentConditionsService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public CurrentConditionsService() {
        retrofit = App.getsAppComponent().getRetrofit();
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
    }

    public Observable<List<CurentContiditions>> getCurrentConditions(String locationkey) {
        return retrofit.create(CurrentConditionsAPI.class).getCurrentConditions(locationkey, Constants.APIKEY, Constants.LANGUAGE, "true");
    }
}
