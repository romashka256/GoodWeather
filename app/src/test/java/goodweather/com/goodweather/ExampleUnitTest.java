package goodweather.com.goodweather;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.presenter.QuestionFragPresenter;
import goodweather.com.goodweather.ui.interfaces.IQuestFragment$$State;

import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    IQuestFragment$$State view;

    QuestionFragPresenter dp;
    private WhyModel whyModel;

    @Before
    public void setUp() {
        view = Mockito.mock(IQuestFragment$$State.class);

        whyModel = new WhyModel("1","2");
        dp = new QuestionFragPresenter(whyModel);

        dp.setViewState(view);
    }

    @Test
    public void shouldCallGetMethod() {
        dp.onViewCreated();

        verify(view).showQuest(whyModel);
    }
}