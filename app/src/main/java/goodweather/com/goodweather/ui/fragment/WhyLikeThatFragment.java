package goodweather.com.goodweather.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.App;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.presenter.WhyLikeThatPresetner;
import goodweather.com.goodweather.presenter.listeners.OnQuestionsClicked;
import goodweather.com.goodweather.ui.adapter.WhyLikeThatAdapter;
import goodweather.com.goodweather.ui.interfaces.IWhyLikeThatActivity;

public class WhyLikeThatFragment extends MvpAppCompatFragment implements IWhyLikeThatActivity,
                                                                         OnQuestionsClicked {

    @BindView(R.id.why_listview)
    ListView listView;
    private Context context;

    @InjectPresenter
    WhyLikeThatPresetner whyLikeThatPresetner;

    public static final String WhyLikeThatFragmentTAG = "WhyLikeThatFragment";

    public static WhyLikeThatFragment newInstance() {
        final WhyLikeThatFragment fragment = new WhyLikeThatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        whyLikeThatPresetner.onCreate();

        context = App.getsAppComponent().getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.why_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        whyLikeThatPresetner.onViewCreated();
    }

    @Override
    public void showQuestions(List<WhyModel> whyModelList) {
        listView.setAdapter(new WhyLikeThatAdapter(context, whyModelList, this));
    }

    @Override
    public void OnClicked(int position) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, QuestionFragment.newInstance(whyLikeThatPresetner.whyModelToJSON(position)), QuestionFragment.QuestionFragmentTAG);
        ft.addToBackStack(null);
        ft.commit();
    }
}
