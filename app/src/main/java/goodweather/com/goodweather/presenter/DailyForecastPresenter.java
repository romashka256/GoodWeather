package goodweather.com.goodweather.presenter;

import android.os.Bundle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import goodweather.com.goodweather.Utils;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import goodweather.com.goodweather.ui.interfaces.IDailyForecastFragment;

import static goodweather.com.goodweather.ui.fragment.DailyFocastFragment.DailyFocastTAG;

@InjectViewState
public class DailyForecastPresenter extends MvpPresenter<IDailyForecastFragment> {

    DailyForecasts dailyForecasts;

    public void onViewCreated(Bundle bundle){
        parseArguments(bundle);
    }

    public void parseArguments(Bundle bundle){
        String dailyForecastsString = bundle.getString(DailyFocastTAG);
        dailyForecasts =  Utils.getGsonParser().fromJson(dailyForecastsString, DailyForecasts.class);
       // Collections.reverse(dailyForecasts.getDailyForecasts());
        getViewState().showForecast(dailyForecasts);
    }
}
