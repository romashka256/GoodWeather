package goodweather.com.goodweather.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.presenter.QuestionFragPresenter;
import goodweather.com.goodweather.ui.interfaces.IQuestFragment;

public class QuestionFragment extends MvpAppCompatFragment implements IQuestFragment {
    @BindView(R.id.qust_act_question)
    TextView mQuestionTV;
    @BindView(R.id.qust_act_answer)
    TextView mAnswerTV;

    public static final String QuestionFragmentTAG = "QuestionFragment";

    @InjectPresenter
    QuestionFragPresenter questionFragPresenter;

    public static QuestionFragment newInstance(final String content) {
        final QuestionFragment fragment = new QuestionFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(QuestionFragmentTAG, content);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionFragPresenter.onCreate(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionFragPresenter.onViewCreated();
    }

    @Override
    public void showQuest(WhyModel whyModel) {
        mQuestionTV.setText(whyModel.getAsk());
        mAnswerTV.setText(whyModel.getText());
    }
}
