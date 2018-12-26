package goodweather.com.goodweather.model.models.currentconditions.metric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class TemperatureMetric {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float TemperatureMetricValue;
    @SerializedName("Unit")
    @Expose
    public String TemperatureMetricUnit;
    @SerializedName("UnitType")
    @Expose
    public Integer TemperatureMetricUnitType;
}
