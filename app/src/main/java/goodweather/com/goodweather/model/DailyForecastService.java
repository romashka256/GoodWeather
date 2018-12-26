package goodweather.com.goodweather.model;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.Constants;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.model.api.DailyForecastAPI;
import goodweather.com.goodweather.presenter.listeners.OnDailyForcastLoadedListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import timber.log.Timber;

public class DailyForecastService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    public DailyForecastService() {
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        retrofit = App.getsAppComponent().getRetrofit();
    }

    public void getDailyForecast(String locationkey, final OnDailyForcastLoadedListener onDailyForcastLoadedListener) {
        Disposable disposable = retrofit.create(DailyForecastAPI.class).getDailyForecast(locationkey, Constants.APIKEY, Constants.LANGUAGE, "true")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onDailyForcastLoadedListener::OnDailyForecastLoaded, throwable -> Timber.e(throwable, throwable.getMessage()));
        mainActivityDisposablesManager.getCollection().add(disposable);
    }
}
