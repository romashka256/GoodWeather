package goodweather.com.goodweather.ui.interfaces;

import com.arellomobile.mvp.MvpView;

import goodweather.com.goodweather.model.models.WhyModel;

public interface IQuestFragment extends MvpView {
    void showQuest(WhyModel whyModel);
}
