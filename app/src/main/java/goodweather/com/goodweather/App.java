package goodweather.com.goodweather;

import android.app.Application;

import goodweather.com.goodweather.di.components.AppComponent;
import goodweather.com.goodweather.di.components.DaggerAppComponent;
import goodweather.com.goodweather.di.modules.ContextModule;
import goodweather.com.goodweather.di.modules.DBModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .dBModule(new DBModule(getApplicationContext()))
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

    }

    public static AppComponent getsAppComponent() {
        return sAppComponent;
    }
}
