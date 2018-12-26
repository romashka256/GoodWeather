package goodweather.com.goodweather.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import java.util.List;

import goodweather.com.goodweather.App;

public class GeoPositionService {

    private LocationManager locationManager;
    private Context context;

    public GeoPositionService() {
        context = App.getsAppComponent().getApplicationContext();
    }

    @SuppressLint("MissingPermission")
    public String getLongitudeAndLatitude() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(false);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return "46.469391, 30.740883";
//        return bestLocation.getLatitude() + "," + bestLocation.getLongitude();
    }
}
