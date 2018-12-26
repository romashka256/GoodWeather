package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.MainActivityDisposablesManager;

@Module
public class CompositeDesposableModule {

    @Singleton
    @Provides
    public MainActivityDisposablesManager provide(){
        return new MainActivityDisposablesManager();
    }

}
