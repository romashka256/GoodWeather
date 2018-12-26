package goodweather.com.goodweather.model.api;

import io.reactivex.Observable;
import goodweather.com.goodweather.model.models.Location;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationAPI {

    @GET("locations/v1/cities/geoposition/search")
    Observable<Location> getLocation(@Query("apikey") String apikey, @Query("q") String latitudeANDlongitude, @Query("language") String language);

}
