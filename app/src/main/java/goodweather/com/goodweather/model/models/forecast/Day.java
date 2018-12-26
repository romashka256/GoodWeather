package goodweather.com.goodweather.model.models.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Day{


    @Getter
    @SerializedName("Icon")
    @Expose
    public Integer icon;
    @Getter
    @SerializedName("IconPhrase")
    @Expose
    public String iconPhrase;

}
