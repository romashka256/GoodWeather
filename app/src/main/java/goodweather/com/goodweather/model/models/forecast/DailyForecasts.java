package goodweather.com.goodweather.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class DailyForecasts {
    @Getter
    @Setter
    @SerializedName("DailyForecasts")
    @Expose
    public List<DailyForecast> dailyForecasts = null;
}
