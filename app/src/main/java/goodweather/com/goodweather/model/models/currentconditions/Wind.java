package goodweather.com.goodweather.model.models.currentconditions;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Wind {
    @Getter
    @SerializedName("Direction")
    @Expose
    @Embedded
    public Direction direction;
    @Getter
    @SerializedName("Speed")
    @Expose
    @Embedded
    public WindSpeed speed;
}
