package michal.beers.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import michal.beers.ApplicationScope;
import michal.beers.api.Api;
import michal.beers.dao.BeerDao;
import michal.beers.data.PreferencesManager;
import michal.beers.room.BeerDatabase;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @ApplicationScope
    PreferencesManager providePreferencesManager(Context context) {
        return new PreferencesManager(context);
    }

    @Provides
    @ApplicationScope
    BeerDatabase provideBeerDatabase(Context context) {
        return Room.databaseBuilder(context, BeerDatabase.class, "beer-room-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @ApplicationScope
    BeerDao provideBeerDao(BeerDatabase beerDatabase) {
        return beerDatabase.beerDao();
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
