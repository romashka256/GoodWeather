package goodweather.com.goodweather.presenter;

import android.os.Bundle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import goodweather.com.goodweather.Utils;
import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import goodweather.com.goodweather.ui.interfaces.ICurrentConditionsFragment;
import lombok.Getter;
import lombok.Setter;

import static goodweather.com.goodweather.ui.fragment.CurrentConditionsFragment.CurentContiditionsTAG;

@InjectViewState
public class CurrentConditionsFragmentPresenter extends MvpPresenter<ICurrentConditionsFragment> {

    @Getter
    @Setter
    private CurentContiditions curentContiditions;

    public void onViewCreated() {
        getViewState().showCurrentConditions(curentContiditions);
    }

    public void setBundle(Bundle bundle) {
        String curentContiditionsString = bundle.getString(CurentContiditionsTAG);
        curentContiditions = Utils.getGsonParser().fromJson(curentContiditionsString, CurentContiditions.class);
    }
}
