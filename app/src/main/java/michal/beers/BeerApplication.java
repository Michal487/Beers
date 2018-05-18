package michal.beers;

import android.app.Application;

import michal.beers.di.AppComponent;
import michal.beers.di.AppModule;
import michal.beers.di.DaggerAppComponent;
import michal.beers.di.DataModule;
import timber.log.Timber;

public class BeerApplication extends Application {

    private AppComponent appComponent;

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

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

