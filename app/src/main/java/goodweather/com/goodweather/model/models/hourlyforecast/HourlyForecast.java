package goodweather.com.goodweather.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import goodweather.com.goodweather.model.models.currentconditions.Wind;
import lombok.Getter;
import lombok.Setter;


public class HourlyForecast {


    @Getter
    @SerializedName("DateTime")
    @Expose
    public String dateTime;
    @Getter
    @SerializedName("EpochDateTime")
    @Expose
    public Long epochDateTime;
    @Getter
    @SerializedName("WeatherIcon")
    @Expose
    public Integer weatherIcon;
    @Getter
    @SerializedName("IconPhrase")
    @Expose
    public String iconPhrase;
    @Getter
    @SerializedName("IsDaylight")
    @Expose
    public Boolean isDaylight;
    @Getter
    @SerializedName("Temperature")
    @Expose
    public Temperature temperature;
    @Getter
    @SerializedName("RealFeelTemperature")
    @Expose
    public RealFeelTemperature realFeelTemperature;
    @Getter
    @SerializedName("Wind")
    @Expose
    public Wind wind;
    @Getter
    @SerializedName("RelativeHumidity")
    @Expose
    public Integer relativeHumidity;
    @Getter
    @SerializedName("UVIndex")
    @Expose
    public Integer uVIndex;
    @Getter
    @SerializedName("UVIndexText")
    @Expose
    public String uVIndexText;
    @Getter
    @SerializedName("PrecipitationProbability")
    @Expose
    public Integer precipitationProbability;
    @Getter
    @SerializedName("RainProbability")
    @Expose
    public Integer rainProbability;
    @Getter
    @SerializedName("SnowProbability")
    @Expose
    public Integer snowProbability;
    @Getter
    @SerializedName("IceProbability")
    @Expose
    public Integer iceProbability;
    @Getter
    @SerializedName("Rain")
    @Expose
    public Rain rain;
    @Getter
    @SerializedName("Snow")
    @Expose
    public Snow snow;
    @Getter
    @SerializedName("Ice")
    @Expose
    public Ice ice;
    @Getter
    @SerializedName("CloudCover")
    @Expose
    public Integer cloudCover;

    @Getter
    @Setter
    public String date;

}
