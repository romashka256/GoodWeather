package goodweather.com.goodweather.model.api;

import io.reactivex.Observable;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DailyForecastAPI {

    @GET("forecasts/v1/daily/5day/{locationkey}")
    Observable<DailyForecasts> getDailyForecast(@Path("locationkey") String locationkey, @Query("apikey") String apikey, @Query("language") String language, @Query("metric") String metric);

}
