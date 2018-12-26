package goodweather.com.goodweather.di.modules;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.PermissionHandlerAndroid;


@Module
public class PermissionModule {

    private AppCompatActivity activity;

    public PermissionModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public PermissionHandlerAndroid getPersmissionHandler(){
        return new PermissionHandlerAndroid(activity);
    }
}
