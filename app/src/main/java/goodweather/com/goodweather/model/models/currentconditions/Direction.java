package goodweather.com.goodweather.model.models.currentconditions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Direction {

    @Getter
    @SerializedName("Degrees")
    @Expose
    public Integer Directiondegrees;
    @Getter
    @SerializedName("Localized")
    @Expose
    public String Directionlocalized;
    @SerializedName("English")
    @Expose
    public String Directionenglish;

}
