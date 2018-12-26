package goodweather.com.goodweather.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Temperature {
    @Getter
    @SerializedName("Value")
    @Expose
    public Double RealFeelTemperaturevalue;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String RealFeelTemperatureunit;
    @SerializedName("UnitType")
    @Expose
    public Integer RealFeelTemperatureunitType;
}
