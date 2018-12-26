package goodweather.com.goodweather.model;

import java.util.List;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.Constants;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.model.api.CitiesSearchAPI;
import goodweather.com.goodweather.model.models.city.City;
import io.reactivex.Observable;
import retrofit2.Retrofit;

public class SearchService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public SearchService() {
        retrofit = App.getsAppComponent().getRetrofit();
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
    }

    public Observable<List<City>> getSearchResult(String text) {
        return retrofit.create(CitiesSearchAPI.class).getCitiesByText(Constants.APIKEY, "false", text, Constants.LANGUAGE);
    }
}
