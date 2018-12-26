package goodweather.com.goodweather.model.api;


import java.util.List;

import io.reactivex.Observable;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CurrentConditionsAPI {

    @GET("currentconditions/v1/{locationkey}")
    Observable<List<CurentContiditions>> getCurrentConditions(@Path("locationkey") String locationkey, @Query("apikey") String apikey, @Query("language") String language, @Query("details") String details);
}
