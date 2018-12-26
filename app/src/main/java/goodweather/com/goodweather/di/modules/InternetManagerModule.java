package goodweather.com.goodweather.di.modules;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.utils.InternetManagerApp;


@Module
public class InternetManagerModule {
    @Provides
    public InternetManagerApp provideManager() {
        return new InternetManagerApp();
    }
}
