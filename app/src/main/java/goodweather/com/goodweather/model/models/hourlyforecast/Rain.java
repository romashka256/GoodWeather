package goodweather.com.goodweather.model.models.hourlyforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Rain  {

    @Getter
    @SerializedName("Value")
    @Expose
    public Integer value;
    @Getter
    @SerializedName("Unit")
    @Expose
    public String unit;
    @SerializedName("UnitType")
    @Expose
    public Integer unitType;
}
