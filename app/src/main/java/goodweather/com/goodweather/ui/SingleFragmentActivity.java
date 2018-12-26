package goodweather.com.goodweather.ui;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import goodweather.com.goodweather.R;

public abstract class SingleFragmentActivity extends MvpAppCompatActivity {

    protected int getLayoutResId() {
        return R.layout.navigationdrawer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

    }
}
