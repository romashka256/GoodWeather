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

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.App;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import goodweather.com.goodweather.presenter.DailyForecastPresenter;
import goodweather.com.goodweather.ui.adapter.DailyForecastAdapter;
import goodweather.com.goodweather.ui.interfaces.IDailyForecastFragment;

public class DailyFocastFragment extends MvpAppCompatFragment implements IDailyForecastFragment {

    @BindView(R.id.daily_forecast_rv)
    RecyclerView mForecastList;

    @InjectPresenter
    DailyForecastPresenter dailyForecastPresenter;

    DailyForecastAdapter dailyForecastAdapter;

    private Context context;

    public static final String DailyFocastTAG = "DailyFocast";

    public static DailyFocastFragment newInstance(final String content) {
        final DailyFocastFragment fragment = new DailyFocastFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(DailyFocastTAG, content);
        fragment.setArguments(arguments);

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
        View view = inflater.inflate(R.layout.daily_forecast_fragment, container, false);
        ButterKnife.bind(this, view);
        mForecastList.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            dailyForecastPresenter.onViewCreated(getArguments());
        }
    }

    @Override
    public void showForecast(DailyForecasts dailyForecasts) {
        dailyForecastAdapter = new DailyForecastAdapter(dailyForecasts, context);
        mForecastList.setAdapter(dailyForecastAdapter);
    }
}
