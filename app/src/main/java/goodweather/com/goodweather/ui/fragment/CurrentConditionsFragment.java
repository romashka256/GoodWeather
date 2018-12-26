package goodweather.com.goodweather.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.App;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;
import goodweather.com.goodweather.presenter.CurrentConditionsFragmentPresenter;
import goodweather.com.goodweather.ui.adapter.HourlyAdapter;
import goodweather.com.goodweather.ui.interfaces.ICurrentConditionsFragment;

public class CurrentConditionsFragment extends MvpAppCompatFragment implements
                                                                    ICurrentConditionsFragment {

    @BindView(R.id.main_text_weather)
    TextView mIconPhrase;
    @BindView(R.id.main_temperture)
    TextView mMainTemperature;
    @BindView(R.id.main_text_date)
    TextView mMainDate;
    @BindView(R.id.main_temperture_realfeel)
    TextView mRealFeelTemp;
    @BindView(R.id.main_cloudy_text)
    TextView mCloudyText;
    @BindView(R.id.main_fastwind_text)
    TextView mFastWindText;
    @BindView(R.id.main_precipitation_text)
    TextView mPrecipitaionText;
    @BindView(R.id.main_pressure_text)
    TextView mPressureText;
    @BindView(R.id.main_visibility_text)
    TextView mVisibilityText;
    @BindView(R.id.main_wind_text)
    TextView mWindText;
    @BindView(R.id.hourly_forecast_list)
    RecyclerView hourlyForcastList;

    @InjectPresenter
    CurrentConditionsFragmentPresenter currentConditionsFragmentPresenter;

    HourlyAdapter hourlyAdapter;

    public static final String CurentContiditionsTAG = "CurrentConditions";
    private Context context;

    public static CurrentConditionsFragment newInstance() {
        final CurrentConditionsFragment fragment = new CurrentConditionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = App.getsAppComponent().getApplicationContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.curent_conditions_fragment, container, false);

        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            currentConditionsFragmentPresenter.setBundle(getArguments());
            currentConditionsFragmentPresenter.onViewCreated();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    public void updateHourlyForcast(List<HourlyForecast> hourlyForecasts) {
        HourlyAdapter hourlyAdapter = new HourlyAdapter(hourlyForecasts, context);
        hourlyForcastList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        hourlyForcastList.setAdapter(hourlyAdapter);
    }

    public void showCurrentConditions(CurentContiditions curentContiditions) {
        //Glide.with(this).load(curentContiditions.getImageUrl()).into(mImageView);
        mMainTemperature.setText(curentContiditions.getTemperature().getCurrentTemperaturMetric().getTemperatureMetricValue().toString());
        mIconPhrase.setText(curentContiditions.getWeatherText());
        mMainDate.setText(curentContiditions.getDate());
        mCloudyText.setText(curentContiditions.getCloudCover().toString());
        mPrecipitaionText.setText(curentContiditions.getHasPrecipitation().equals("false") ? "Нет" : "Есть");
        mPressureText.setText(curentContiditions.getPressure().getPressuremetric().getCurrentvalue().toString());
        mWindText.setText(curentContiditions.getWind().getSpeed().getWindSpeedmetric().WindSpeedMetricvalue.toString());
        mVisibilityText.setText(curentContiditions.getObstructionsToVisibility());
        mRealFeelTemp.setText("RealFeel " + curentContiditions.getRealFeelTemperature().RealFeelTemperaturemetric.RealFeelTemperatureMetricValue.toString());
        mFastWindText.setText(curentContiditions.getRelativeHumidity().toString());
    }
}