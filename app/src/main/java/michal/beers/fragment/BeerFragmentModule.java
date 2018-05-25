package michal.beers.fragment;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BeerFragmentModule {


    private BeerFragmentContract.View view;

    public BeerFragmentModule(BeerFragmentContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    BeerFragmentContract.Presenter provideDetailsFragmentPresenter() {
        return new BeerFragmentPresenter(view);
    }

}
