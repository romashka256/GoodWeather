package goodweather.com.goodweather.ui.interfaces;

import com.arellomobile.mvp.MvpView;

import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;

public interface ICurrentConditionsFragment extends MvpView {
    void showCurrentConditions(CurentContiditions curentContiditions);
}
