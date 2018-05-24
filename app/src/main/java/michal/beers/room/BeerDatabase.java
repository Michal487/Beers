package michal.beers.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import michal.beers.dao.BeerDao;
import michal.beers.data.Beer;

@Database(entities = {Beer.class}, version = 1)
public abstract class BeerDatabase extends RoomDatabase {

    public abstract BeerDao beerDao();

}
