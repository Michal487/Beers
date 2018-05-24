package michal.beers.activity.beer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import michal.beers.api.Api;
import michal.beers.dao.BeerDao;

@Module
public class BeerModule {

    private BeerContract.View view;

    public BeerModule(BeerContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    BeerContract.Presenter providesBeerPresenter(Api api, BeerDao beerDao) {
        return new BeerPresenter(view, api, beerDao);

    }

}
