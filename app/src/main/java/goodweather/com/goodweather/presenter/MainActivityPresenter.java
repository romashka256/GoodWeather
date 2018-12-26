package goodweather.com.goodweather.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.RxSearchFlowable;
import goodweather.com.goodweather.Utils;
import goodweather.com.goodweather.model.CurrentConditionsService;
import goodweather.com.goodweather.model.DailyForecastService;
import goodweather.com.goodweather.model.HourForecastService;
import goodweather.com.goodweather.model.LocationService;
import goodweather.com.goodweather.model.SearchService;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import goodweather.com.goodweather.model.models.db.AppDB;
import goodweather.com.goodweather.model.models.db.CurrentConditionsDao;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;
import goodweather.com.goodweather.ui.interfaces.IMainActivityView;
import goodweather.com.goodweather.utils.InternetManagerApp;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;
import timber.log.Timber;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<IMainActivityView> {

    @Inject
    LocationService locationService;
    @Inject
    DailyForecastService dailyForecast;
    @Inject
    CurrentConditionsService currentConditionsService;
    @Inject
    HourForecastService hourForecastService;
    @Inject
    MainActivityDisposablesManager mainActivityDisposablesManager;
    @Inject
    InternetManagerApp internetManagerApp;
    @Inject
    SearchService searchService;
    @Inject
    AppDB appDB;
    @Inject
    RxSearchFlowable rxSearchFlowable;

    @Getter
    public boolean loadedState;

    CurrentConditionsDao currentConditionsDao;
    private DailyForecasts dailyForecasts;
    @Getter
    List<HourlyForecast> hourlyForecasts;
    private CurentContiditions curentContiditions;
    private Context context;
    private List<WhyModel> whyModels;


    @Inject
    public MainActivityPresenter() {
        context = App.getsAppComponent().getApplicationContext();
        App.getsAppComponent().inject(this);
        loadedState = false;
        currentConditionsDao = appDB.CurrentConditionsDao();
    }

    public void OnCreate() {
        getLocationAndData();
    }

    public void setSearchObserver(SearchView searchView) {
        mainActivityDisposablesManager.getCollection().add(
                rxSearchFlowable.fromView(searchView)
                        .debounce(300, TimeUnit.MICROSECONDS)
                        .filter(String::isEmpty)
                        .distinctUntilChanged()
                        .switchMap(q -> searchService.getSearchResult(q)
                                .doOnError(throwable -> Log.e("setSearchObserver", throwable.getMessage()))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .doOnError(throwable -> Log.e("setSearchObserver", throwable.getMessage()))
                        .subscribe(result -> getViewState().showResult(result), throwable -> Timber.e(throwable)));
    }


    private void getDailyForecast(String key) {
        dailyForecast.getDailyForecast(key, dailyForecast -> {
            dailyForecasts = dailyForecast;
            getViewState().showDailyForecastData(dailyForecast);
        });
    }

    private void getCurrentConditions(String key) {
        mainActivityDisposablesManager.getCollection().add(currentConditionsService.getCurrentConditions(key)
                .map(curentContiditions -> {
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd EEEE");
                    String date = sdf.format(new Date(curentContiditions.get(0).getEpochTime() * 1000));
                    curentContiditions.get(0).setDate(date);
                    return curentContiditions.get(0);
                })
                .doOnNext(curentContiditions -> currentConditionsDao.insertCurrentCondition(curentContiditions))
                .doOnError(throwable -> Log.e("getCurrentConditions", throwable.getMessage()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(curentContiditions -> {
                    this.curentContiditions = curentContiditions;
                    getViewState().showCurrentConditions(curentContiditions);
                    loadedState = true;
                }, throwable -> Timber.e(throwable)));
    }

    private void getHourlyForecast(String key) {
        mainActivityDisposablesManager.getCollection().add(hourForecastService.get12HourForecast(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(hourlyForecasts -> {
                    if (hourlyForecasts != null && hourlyForecasts.size() != 0) {
                        getViewState().showHourlyForcast(hourlyForecasts);
                    }
                    this.hourlyForecasts = hourlyForecasts;
                }));
    }

    private void getLocationAndData() {
        locationService.getLocation(location -> {
            if (location.getLocalizedName().equals("")) {
                location.setLocalizedName(location.getEnglishName());
            }
            getViewState().showCity(location);
            getCurrentConditions(location.getKey());
            getDailyForecast(location.getKey());
            getHourlyForecast(location.getKey());
        });
    }

    public void OnStop() {
        mainActivityDisposablesManager.disposeAll();
    }

    public void onSearchTextChanged(String text) {

    }

    public void loadDataForCity(String key) {
        getCurrentConditions(key);
        getDailyForecast(key);
        getHourlyForecast(key);
    }

    public String getDailyForecastJsonString() {
        return Utils.getGsonParser().toJson(dailyForecasts);
    }

    public String getCurrentConditionsJsonString() {
        return goodweather.com.goodweather.Utils.getGsonParser().toJson(curentContiditions);

    }

}