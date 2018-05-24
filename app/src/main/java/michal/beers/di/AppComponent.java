package michal.beers.di;

import dagger.Component;
import michal.beers.ApplicationScope;
import michal.beers.activity.beer.BeerComponent;
import michal.beers.activity.beer.BeerModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    BeerComponent plus(BeerModule beerModule);

}
