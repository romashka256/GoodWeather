package goodweather.com.goodweather.presenter;

import android.os.Bundle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import goodweather.com.goodweather.Utils;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.ui.fragment.QuestionFragment;
import goodweather.com.goodweather.ui.interfaces.IQuestFragment;
import lombok.Getter;

@InjectViewState
public class QuestionFragPresenter extends MvpPresenter<IQuestFragment> {

    @Getter
    WhyModel whyModel;

    public QuestionFragPresenter(WhyModel whyModel) {
        this.whyModel = whyModel;
    }

    public QuestionFragPresenter() {
    }

    public void onCreate(Bundle bundle) {
        whyModel = Utils.getGsonParser().fromJson(bundle.getString(QuestionFragment.QuestionFragmentTAG), WhyModel.class);
    }

    public void onViewCreated() {
        getViewState().showQuest(whyModel);
    }
}
