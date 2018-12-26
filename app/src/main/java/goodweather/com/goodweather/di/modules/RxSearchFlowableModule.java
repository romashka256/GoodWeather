package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.RxSearchFlowable;

@Module
public class RxSearchFlowableModule {

    @Provides
    @Singleton
    public RxSearchFlowable provideRxSearchFlowable(){
        return new RxSearchFlowable();
    }
}
