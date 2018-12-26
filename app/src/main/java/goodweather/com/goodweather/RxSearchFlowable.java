package goodweather.com.goodweather;

import android.support.v7.widget.SearchView;

import io.reactivex.subjects.PublishSubject;

public class RxSearchFlowable {

    final PublishSubject<String> subject = PublishSubject.create();

    public PublishSubject<String> fromView(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                subject.onNext(s);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                subject.onNext(text);
                return true;
            }
        });
        return subject;
    }
}
