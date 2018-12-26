package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.CurrentConditionsService;


@Module
public class CurrentConditionsModule {

    @Singleton
    @Provides
    public CurrentConditionsService provideCurrentCoditions(){
        return new CurrentConditionsService();
    }

}
