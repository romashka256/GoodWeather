package goodweather.com.goodweather.model.models.city;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class City {

    @SerializedName("LocalizedName")
    @Getter
    public String cityName;
    @Getter
    @SerializedName("Country")
    public Country country;
    @Getter
    @SerializedName("Key")
    public String key;
}
