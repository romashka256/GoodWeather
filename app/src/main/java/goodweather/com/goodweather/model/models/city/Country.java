package goodweather.com.goodweather.model.models.city;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Country {

    @SerializedName("LocalizedName")
    @Getter
    public String countryName;

}
