package goodweather.com.goodweather.model.models.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import goodweather.com.goodweather.model.models.currentconditions.CurentContiditions;
import io.reactivex.Maybe;

@Dao
public interface CurrentConditionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCurrentCondition(CurentContiditions curentContiditions);

    @Query("SELECT * FROM currentconditions")
    Maybe<CurentContiditions> getCurentConditions();

}
