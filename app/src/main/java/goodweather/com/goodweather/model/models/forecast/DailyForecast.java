package goodweather.com.goodweather.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class DailyForecast {

    @SerializedName("Date")
    @Expose
    @Setter
    @Getter
    public String date;

    @Getter
    @SerializedName("EpochDate")
    @Expose
    public Long epochDate;
    @Getter
    @SerializedName("Temperature")
    @Expose
    public Temperature temperature;
    @Getter
    @SerializedName("Day")
    @Expose
    public Day day;
    @Getter
    @SerializedName("Night")
    @Expose
    public Night night;
    @Getter
    @SerializedName("Sources")
    @Expose
    public List<String> sources = null;
    @Getter
    @SerializedName("MobileLink")
    @Expose
    public String mobileLink;
    @Getter
    @SerializedName("Link")
    @Expose
    public String link;

}
