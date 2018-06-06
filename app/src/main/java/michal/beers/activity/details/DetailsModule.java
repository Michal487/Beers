package michal.beers.activity.details;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import michal.beers.api.Api;
import michal.beers.dao.BeerDao;

@Module
public class DetailsModule {

    private DetailsContract.View view;

    public DetailsModule(DetailsContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    DetailsContract.Presenter provideDetailsPresenter(BeerDao beerDao) {
        return new DetailsPresenter(view, beerDao);
    }

}
