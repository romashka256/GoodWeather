package goodweather.com.goodweather.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.SearchService;

@Module
public class SearchServiceModule {

    @Singleton
    @Provides
    public SearchService provideSearchService(){
        return new SearchService();
    }

}
