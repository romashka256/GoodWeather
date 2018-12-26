package goodweather.com.goodweather.di.modules;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.GeoPositionService;


@Module
public class GeoPositionModule {

    @Provides
    public GeoPositionService provideGeoPosService(){
        return new GeoPositionService();
    }
}
