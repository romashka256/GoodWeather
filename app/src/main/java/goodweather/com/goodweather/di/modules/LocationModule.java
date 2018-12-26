package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.LocationService;


@Module
public class LocationModule {

    @Singleton
    @Provides
    public LocationService provideLocationService(){
        return new LocationService();
    }

}
