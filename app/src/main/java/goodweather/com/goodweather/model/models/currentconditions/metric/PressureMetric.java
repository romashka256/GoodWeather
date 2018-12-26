package goodweather.com.goodweather.model.models.currentconditions.metric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class PressureMetric {

    @Getter
    @SerializedName("Value")
    @Expose
    public Float currentvalue;
    @SerializedName("Unit")
    @Expose
    public String currentunit;
    @SerializedName("UnitType")
    @Expose
    public Integer currentunitType;
}
