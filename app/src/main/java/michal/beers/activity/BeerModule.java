package michal.beers.activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import michal.beers.api.Api;

@Module
public class BeerModule {

    private final BeerContract.View view;

    public BeerModule(BeerContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    BeerContract.Presenter providesBeerPresenter(Api api) {
        return new BeerPresenter(view, api);

    }

}
