package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.DailyForecastService;

@Module
public class DailyForecastServiceModule {

    @Singleton
    @Provides
    public DailyForecastService provideDailyForecastService(){
        return new DailyForecastService();
    }
}
