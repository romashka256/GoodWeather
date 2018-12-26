package goodweather.com.goodweather.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import goodweather.com.goodweather.model.models.db.AppDB;


@Module
public class DBModule {

    Context context;

    public DBModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public AppDB provideAppDB(){
        return Room.databaseBuilder(context,AppDB.class,"database").build();
    }

}
