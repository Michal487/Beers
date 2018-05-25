package michal.beers.activity.details;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsModule {

    private DetailsContract.View view;

    public DetailsModule(DetailsContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    DetailsContract.Presenter provideDetailsPresenter() {
        return new DatailsPresenter(view);
    }

}
