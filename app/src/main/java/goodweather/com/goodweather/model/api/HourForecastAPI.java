package goodweather.com.goodweather.model.api;

import java.util.List;

import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HourForecastAPI {

    @GET("forecasts/v1/hourly/12hour/{locationkey}")
    Observable<List<HourlyForecast>> get12HoursForecast(@Path("locationkey") String locationkey, @Query("apikey") String apikey, @Query("language") String language, @Query("details") String details, @Query("metric") String metric);

}
