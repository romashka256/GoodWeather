package goodweather.com.goodweather.ui.interfaces;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import goodweather.com.goodweather.model.models.WhyModel;

public interface IWhyLikeThatActivity extends MvpView {
    void showQuestions(List<WhyModel> whyModelList);
}
