package goodweather.com.goodweather.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class MinimumTemperature  {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float MinimumTemperaturevalue;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String MinimumTemperatureunit;
    @Getter
    @SerializedName("UnitType")
    @Expose
    public Integer MinimumTemperatureunitType;
}
