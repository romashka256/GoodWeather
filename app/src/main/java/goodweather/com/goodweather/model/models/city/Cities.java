package goodweather.com.goodweather.model.models.city;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Cities {

    @Getter
    List<City> cityList;

    public Cities() {
        cityList = new ArrayList<>();
    }
}
