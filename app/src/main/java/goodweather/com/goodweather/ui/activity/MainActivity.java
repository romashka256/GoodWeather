package goodweather.com.goodweather.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.PermissionHandlerAndroid;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.di.components.DaggerPermissonHandlerComponent;
import goodweather.com.goodweather.di.modules.PermissionModule;
import goodweather.com.goodweather.model.models.Location;
import goodweather.com.goodweather.model.models.city.City;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import goodweather.com.goodweather.model.models.forecast.DailyForecasts;
import goodweather.com.goodweather.model.models.hourlyforecast.HourlyForecast;
import goodweather.com.goodweather.presenter.MainActivityPresenter;
import goodweather.com.goodweather.ui.SingleFragmentActivity;
import goodweather.com.goodweather.ui.adapter.CitiesAdapter;
import goodweather.com.goodweather.ui.fragment.CurrentConditionsFragment;
import goodweather.com.goodweather.ui.fragment.DailyFocastFragment;
import goodweather.com.goodweather.ui.fragment.WhyLikeThatFragment;
import goodweather.com.goodweather.ui.interfaces.IMainActivityView;

public class MainActivity extends SingleFragmentActivity implements IMainActivityView {

    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    TextView mNavTemperature;
    TextView mNavCity;
    RelativeLayout mNavProgressLay;

    SearchView mSearchView;
    RecyclerView mCitiesList;

    @BindView(R.id.nvView)
    NavigationView navigationView;
    @BindView(R.id.progressbar_bg)
    RelativeLayout mProgressBar;
    @BindView(R.id.daily_forecast_button)
    Button mDailyForecastButton;

    ActionBarDrawerToggle mDrawerToggle;

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;

    private CitiesAdapter citiesAdapter;

    @Inject
    PermissionHandlerAndroid permissionHandlerAndroid;

    @SuppressLint({"MissingPermission", "CheckResult"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);

        ButterKnife.bind(this);
        mDailyForecastButton.setVisibility(View.GONE);

        View headerView = navigationView.getHeaderView(0);

        mNavCity = headerView.findViewById(R.id.nav_view_header_city);
        mSearchView = headerView.findViewById(R.id.nav_view_header_search);
        mNavTemperature = headerView.findViewById(R.id.nav_view_header_temp);
        mNavProgressLay = headerView.findViewById(R.id.nav_progress_layout);
        mCitiesList = navigationView.findViewById(R.id.nav_list);

        mSearchView.setIconified(false);
        mSearchView.requestFocusFromTouch();

        showLoading();

        mCitiesList.setLayoutManager(new LinearLayoutManager(this));
        citiesAdapter = new CitiesAdapter(this, city -> mainActivityPresenter.loadDataForCity(city.getKey()));
        mCitiesList.setAdapter(citiesAdapter);

        mSearchView.setBackgroundResource(R.drawable.searchviewbackground);

        EditText searchEditText = mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        //  int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        // TextView textView = mSearchView.findViewById(id);

//        int searchCloseButtonId = mSearchView.getContext().getResources()
//                .getIdentifier("android:id/search_close_btn", null, null);

        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        //  searchEditText.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        DaggerPermissonHandlerComponent.builder()
                .permissionModule(new PermissionModule(this))
                .build()
                .inject(this);

        permissionHandlerAndroid.getPermissions();

        mainActivityPresenter.OnCreate();

        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mainActivityPresenter.setSearchObserver(mSearchView);

//        mSearchView.setOnQueryTextFocusChangeListener( (view, hasFocus) -> {
//        if (hasFocus) {
//            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
//        } else {
//            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
//        }
//        });

        mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    showInputMethod(view.findFocus());
                }
            }
        });

//        mDailyForecastButton.setOnClickListener();

        mDailyForecastButton.setOnClickListener(view -> {
            mDailyForecastButton.setVisibility(View.GONE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, DailyFocastFragment.newInstance(mainActivityPresenter.getDailyForecastJsonString()), DailyFocastFragment.DailyFocastTAG);
            ft.addToBackStack(null);
            ft.commit();
        });


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, CurrentConditionsFragment.newInstance(), CurrentConditionsFragment.CurentContiditionsTAG);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void showInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(view, 0);
        }
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public void showCity(Location location) {
        getSupportActionBar().setTitle(location.getLocalizedName());
        mNavCity.setText(location.getLocalizedName());
    }

    @Override
    public void showDailyForecastData(DailyForecasts dailyForecast) {
        mDailyForecastButton.setVisibility(View.VISIBLE);
        //   mMainDate.setText(dailyForecast.getDailyForecasts().get(0).getDate());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    public void showCurrentConditions(CurentContiditions curentContiditions) {
        mNavTemperature.setText(curentContiditions.getTemperature().getCurrentTemperaturMetric().getTemperatureMetricValue().toString());
        hideLoading();

        CurrentConditionsFragment currentConditionsFragment = (CurrentConditionsFragment) getSupportFragmentManager().findFragmentByTag(CurrentConditionsFragment.CurentContiditionsTAG);
        if (currentConditionsFragment != null) {
            currentConditionsFragment.showCurrentConditions(curentContiditions);
        }

        mNavProgressLay.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mNavProgressLay.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mNavProgressLay.setVisibility(View.GONE);
    }

    @Override
    public void showResult(List<City> cities) {
        citiesAdapter.getCities().clear();
        citiesAdapter.getCities().addAll(cities);
        citiesAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.question:
                mProgressBar.setVisibility(View.GONE);
                if (getSupportFragmentManager().findFragmentByTag(WhyLikeThatFragment.WhyLikeThatFragmentTAG) == null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.add(R.id.container, WhyLikeThatFragment.newInstance(), WhyLikeThatFragment.WhyLikeThatFragmentTAG);
                    ft.addToBackStack(WhyLikeThatFragment.WhyLikeThatFragmentTAG);
                    ft.commit();
                }
                return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainActivityPresenter.OnStop();
    }

    @Override
    public void showHourlyForcast(List<HourlyForecast> hourlyForecasts) {
        CurrentConditionsFragment currentConditionsFragment = (CurrentConditionsFragment) getSupportFragmentManager().findFragmentByTag(CurrentConditionsFragment.CurentContiditionsTAG);
        if (currentConditionsFragment != null) {
            currentConditionsFragment.updateHourlyForcast(hourlyForecasts);
        }
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().findFragmentByTag(CurrentConditionsFragment.CurentContiditionsTAG) != null
                && getSupportFragmentManager().findFragmentByTag(CurrentConditionsFragment.CurentContiditionsTAG).isVisible()) {
            mDailyForecastButton.setVisibility(View.VISIBLE);
            if (!mainActivityPresenter.isLoadedState()) {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        } else if (getSupportFragmentManager().findFragmentByTag(DailyFocastFragment.DailyFocastTAG) != null
                && getSupportFragmentManager().findFragmentByTag(DailyFocastFragment.DailyFocastTAG).isVisible()) {
            mDailyForecastButton.setVisibility(View.VISIBLE);
            if (!mainActivityPresenter.isLoadedState()) {
                mProgressBar.setVisibility(View.VISIBLE);
            }

        }
        if (getSupportFragmentManager().getFragments().size() != 1) {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}

