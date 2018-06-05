package michal.beers.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import michal.beers.data.Beer;

@Dao
public interface BeerDao {

    @Query("SELECT * FROM Beer")
    List<Beer> getAll();

    @Insert
    void insert(List<Beer> beer);

    @Query("SELECT * FROM Beer WHERE id= :id")
    public abstract Beer getBeerById(String id);

}
