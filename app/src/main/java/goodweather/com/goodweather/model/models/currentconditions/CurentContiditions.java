package goodweather.com.goodweather.model.models.currentconditions;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "currentconditions")
public class CurentContiditions {


    @Getter
    @SerializedName("LocalObservationDateTime")
    @Expose
    public String localObservationDateTime;
    @PrimaryKey
    @Getter
    @SerializedName("EpochTime")
    @Expose
    public Long epochTime;
    @Getter
    @SerializedName("WeatherText")
    @Expose
    public String weatherText;
    @Getter
    @SerializedName("WeatherIcon")
    @Expose
    public Integer weatherIcon;
    @Getter
    @SerializedName("HasPrecipitation")
    @Expose
    public Boolean hasPrecipitation;
    @Getter
    @SerializedName("PrecipitationType")
    @Expose
    public String precipitationType;
    @Getter
    @SerializedName("IsDayTime")
    @Expose
    public Boolean isDayTime;
    @Getter
    @SerializedName("Temperature")
    @Expose
    @Embedded
    public Temperature temperature;
    @Getter
    @SerializedName("RealFeelTemperature")
    @Expose
    @Embedded
    public RealFeelTemperature realFeelTemperature;
    @Getter
    @SerializedName("RelativeHumidity")
    @Expose
    public Integer relativeHumidity;
    @Getter
    @SerializedName("Wind")
    @Expose
    @Embedded
    public Wind wind;
    @SerializedName("UVIndex")
    @Expose
    public Integer uVIndex;
    @Getter
    @SerializedName("UVIndexText")
    @Expose
    public String uVIndexText;
    @Getter
    @SerializedName("ObstructionsToVisibility")
    @Expose
    public String obstructionsToVisibility;
    @Getter
    @SerializedName("CloudCover")
    @Expose
    public Integer cloudCover;
    @Getter
    @SerializedName("Pressure")
    @Expose
    @Embedded
    public Pressure pressure;
    @Getter
    @Setter
    public String date;

    @Getter
    @Setter
    public String imageUrl;

}
