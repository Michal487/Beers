package michal.beers;

import android.app.Application;
import android.arch.persistence.room.Room;

import michal.beers.di.AppComponent;
import michal.beers.di.AppModule;
import michal.beers.di.DaggerAppComponent;
import michal.beers.di.DataModule;
import michal.beers.room.BeerDatabase;
import timber.log.Timber;

public class BeerApplication extends Application {

    private AppComponent appComponent;
    private static BeerDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + " *** " + element.getLineNumber();
                }
            });
        }

        //Dagger2
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();

        //Room
        database = Room.databaseBuilder(this, BeerDatabase.class, "beer-room-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static BeerDatabase getRoom() {
        return database;
    }
}

