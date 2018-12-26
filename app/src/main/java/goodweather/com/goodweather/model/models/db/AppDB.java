package goodweather.com.goodweather.model.models.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;

@Database(entities = {CurentContiditions.class}, version = 1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {

    public abstract CurrentConditionsDao CurrentConditionsDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() { 
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
