package goodweather.com.goodweather.di.components;

import dagger.Component;
import goodweather.com.goodweather.di.modules.GeoPositionModule;
import goodweather.com.goodweather.model.LocationService;

@Component(modules = GeoPositionModule.class)
public interface GeoPosComponent {
    void inject(LocationService locationService);
}
