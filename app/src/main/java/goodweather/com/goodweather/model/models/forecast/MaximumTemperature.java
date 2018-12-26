package goodweather.com.goodweather.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class MaximumTemperature{

    @Getter
    @SerializedName("Value")
    @Expose
    public Float MaximumTemperaturevalue;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String MaximumTemperatureunit;
    @Getter
    @SerializedName("UnitType")
    @Expose
    public Integer MaximumTemperatureunitType;

}
