package michal.beers.activity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {BeerModule.class})
public interface BeerComponent {

    void inject(BeerActivity beerActivity);

}
