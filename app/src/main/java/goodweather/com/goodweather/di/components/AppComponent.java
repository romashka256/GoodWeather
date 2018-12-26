package goodweather.com.goodweather.di.components;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import goodweather.com.goodweather.RxSearchFlowable;
import goodweather.com.goodweather.di.modules.DBModule;
import goodweather.com.goodweather.di.modules.RxSearchFlowableModule;
import goodweather.com.goodweather.di.modules.SearchServiceModule;
import goodweather.com.goodweather.utils.InternetManagerApp;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.di.modules.CompositeDesposableModule;
import goodweather.com.goodweather.di.modules.ContextModule;
import goodweather.com.goodweather.di.modules.CurrentConditionsModule;
import goodweather.com.goodweather.di.modules.DailyForecastServiceModule;
import goodweather.com.goodweather.di.modules.HourlyForecastModule;
import goodweather.com.goodweather.di.modules.InternetManagerModule;
import goodweather.com.goodweather.di.modules.LocationModule;
import goodweather.com.goodweather.di.modules.RetrofitModule;
import goodweather.com.goodweather.model.CurrentConditionsService;
import goodweather.com.goodweather.model.DailyForecastService;
import goodweather.com.goodweather.model.HourForecastService;
import goodweather.com.goodweather.model.LocationService;
import goodweather.com.goodweather.presenter.MainActivityPresenter;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {RxSearchFlowableModule.class,SearchServiceModule.class, InternetManagerModule.class, CompositeDesposableModule.class,  HourlyForecastModule.class, RetrofitModule.class, ContextModule.class, LocationModule.class, DailyForecastServiceModule.class, CurrentConditionsModule.class, DBModule.class})
public interface AppComponent {

    Retrofit getRetrofit();
    Context getApplicationContext();
    LocationService getLocationService();
    DailyForecastService getDailyForecastService();
    CurrentConditionsService getCurrentConditionsService();
    HourForecastService getHourForecastService();
    MainActivityDisposablesManager getMainActivityDisposablesManager();
    InternetManagerApp getInternetManger();
    RxSearchFlowable getRxSearchFlowable();

    void inject(MainActivityPresenter mainActivityPresenter);

}
