package goodweather.com.goodweather.model.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class Location {

//    @PrimaryKey(autoGenerate = true)
//    public long id;
    @SerializedName("Version")
    @Expose
    public Integer version;
    @Getter
    @SerializedName("Key")
    @Expose
    public String key;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("Rank")
    @Expose
    public Integer rank;
    @Setter
    @Getter
    @SerializedName("LocalizedName")
    @Expose
    public String localizedName;
    @Getter
    @SerializedName("EnglishName")
    @Expose
    public String englishName;
    @SerializedName("PrimaryPostalCode")
    @Expose
    public String primaryPostalCode;
    @Expose
    public Boolean isAlias;
}
