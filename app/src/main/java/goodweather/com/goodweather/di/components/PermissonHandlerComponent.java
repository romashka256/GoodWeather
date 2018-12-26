package goodweather.com.goodweather.di.components;

import dagger.Component;
import goodweather.com.goodweather.di.modules.PermissionModule;
import goodweather.com.goodweather.ui.activity.MainActivity;

@Component(modules = PermissionModule.class)
public interface PermissonHandlerComponent {

    void inject(MainActivity mainActivity);

}
