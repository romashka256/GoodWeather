package goodweather.com.goodweather.model;

import android.util.Log;

import javax.inject.Inject;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.Constants;
import goodweather.com.goodweather.MainActivityDisposablesManager;
import goodweather.com.goodweather.di.components.DaggerGeoPosComponent;
import goodweather.com.goodweather.model.api.LocationAPI;
import goodweather.com.goodweather.model.models.Location;
import goodweather.com.goodweather.presenter.listeners.OnLocationGetSuccess;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LocationService {

    private Retrofit retrofit;
    private MainActivityDisposablesManager mainActivityDisposablesManager;

    @Inject
    GeoPositionService geoPositionService;


    public LocationService() {
        retrofit = App.getsAppComponent().getRetrofit();
        mainActivityDisposablesManager = App.getsAppComponent().getMainActivityDisposablesManager();
        DaggerGeoPosComponent.builder()
                .build()
                .inject(this);
    }

    public void getLocation(final OnLocationGetSuccess listener) {
        Disposable disposable = retrofit.create(LocationAPI.class).getLocation(Constants.APIKEY, geoPositionService.getLongitudeAndLatitude(), Constants.LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("getLocation", throwable.getMessage());
                    }
                })
                .subscribe(new Consumer<Location>() {
                    @Override
                    public void accept(Location location) throws Exception {
                        listener.OnLocationFound(location);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("getLocation", throwable.getMessage());
                    }
                });
        mainActivityDisposablesManager.getCollection().add(disposable);
    }
}
