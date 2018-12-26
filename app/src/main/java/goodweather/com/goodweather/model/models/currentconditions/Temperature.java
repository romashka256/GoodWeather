package goodweather.com.goodweather.model.models.currentconditions;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import goodweather.com.goodweather.model.models.currentconditions.metric.TemperatureMetric;
import lombok.Getter;

public class Temperature {
    @Getter
    @SerializedName("Metric")
    @Expose
    @Embedded
    public TemperatureMetric CurrentTemperaturMetric;

}
