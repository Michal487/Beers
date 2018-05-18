package michal.beers.di;

import dagger.Component;
import michal.beers.ApplicationScope;
import michal.beers.activity.BeerComponent;
import michal.beers.activity.BeerModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    BeerComponent plus(BeerModule beerModule);

}
