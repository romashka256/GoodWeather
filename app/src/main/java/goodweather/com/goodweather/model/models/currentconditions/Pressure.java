package goodweather.com.goodweather.model.models.currentconditions;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import goodweather.com.goodweather.model.models.currentconditions.metric.PressureMetric;
import lombok.Getter;

public class Pressure {

    @Getter
    @SerializedName("Metric")
    @Expose
    @Embedded
    public PressureMetric Pressuremetric;

}
