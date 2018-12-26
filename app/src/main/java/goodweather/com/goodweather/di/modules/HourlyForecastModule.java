package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.HourForecastService;


@Module
public class HourlyForecastModule {

    @Singleton
    @Provides
    public HourForecastService provideHourlyForecastService(){
        return new HourForecastService();
    }

}
