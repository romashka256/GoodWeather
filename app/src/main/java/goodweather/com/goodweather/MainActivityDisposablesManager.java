package goodweather.com.goodweather;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityDisposablesManager {

    private CompositeDisposable compositeDisposable;

    public MainActivityDisposablesManager() {
        compositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCollection() {
        return compositeDisposable;
    }

    public void disposeAll() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
