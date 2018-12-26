package goodweather.com.goodweather.model.models.currentconditions.metric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class WindSpeedMetric {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float WindSpeedMetricvalue;
    @SerializedName("Unit")
    @Expose
    public String WindSpeedMetricunit;
    @SerializedName("UnitType")
    @Expose
    public Integer WindSpeedMetricUnitType;
}
