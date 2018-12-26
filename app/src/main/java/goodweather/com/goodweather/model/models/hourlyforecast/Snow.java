package goodweather.com.goodweather.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Snow {
    @Getter
    @SerializedName("Value")
    @Expose
    public Integer RealFeelTemperaturevalue;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String RealFeelTemperatureunit;
    @SerializedName("UnitType")
    @Expose
    public Integer RealFeelTemperatureunitType;
}
