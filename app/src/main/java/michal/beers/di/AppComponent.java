package michal.beers.di;

import dagger.Component;
import michal.beers.ApplicationScope;
import michal.beers.activity.beer.BeerComponent;
import michal.beers.activity.beer.BeerModule;
import michal.beers.activity.details.DetailsComponent;
import michal.beers.activity.details.DetailsModule;
import michal.beers.fragment.BeerFragmentComponent;
import michal.beers.fragment.BeerFragmentModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    BeerComponent plus(BeerModule beerModule);

    DetailsComponent plus(DetailsModule detailsModule);

    BeerFragmentComponent plus(BeerFragmentModule detailsFragmentModule);

}
