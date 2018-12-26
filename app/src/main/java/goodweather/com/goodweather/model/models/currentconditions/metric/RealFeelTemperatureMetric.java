package goodweather.com.goodweather.model.models.currentconditions.metric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class RealFeelTemperatureMetric {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float RealFeelTemperatureMetricValue;
    @SerializedName("Unit")
    @Expose
    public String RealFeelTemperatureMetricUnit;
    @SerializedName("UnitType")
    @Expose
    public Integer RealFeelTemperatureMetricUnitType;

}
