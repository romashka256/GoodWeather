package goodweather.com.goodweather.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import goodweather.com.goodweather.App;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.Utils;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.ui.interfaces.IWhyLikeThatActivity;

@InjectViewState
public class WhyLikeThatPresetner extends MvpPresenter<IWhyLikeThatActivity> {

    private List<WhyModel> whyModels;
    private Context context;

    public WhyLikeThatPresetner() {
        this.context = App.getsAppComponent().getApplicationContext();
    }

    public void onCreate() {
        whyModels = new ArrayList<>();

        List<String> questions = Arrays.asList(context.getResources().getStringArray(R.array.quest));
        List<String> answers = Arrays.asList(context.getResources().getStringArray(R.array.answers));

        for (int i = 0; i < questions.size() - 1; i++) {
            whyModels.add(new WhyModel(questions.get(i), answers.get(i)));
        }
    }

    public void onViewCreated() {
        getViewState().showQuestions(whyModels);
    }

    public String whyModelToJSON(int pos) {
        return Utils.getGsonParser().toJson(whyModels.get(pos));
    }
}
