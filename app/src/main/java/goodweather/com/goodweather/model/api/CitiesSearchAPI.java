package goodweather.com.goodweather.model.api;

import java.util.List;

import goodweather.com.goodweather.model.models.city.City;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CitiesSearchAPI {

    @GET("locations/v1/cities/search")
    Observable<List<City>> getCitiesByText(@Query("apikey") String apikey, @Query("details") String details, @Query("q") String text, @Query("language") String language);

}
