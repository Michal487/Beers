package michal.beers.activity.details;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent {

    void inject(DetailsActivity detailsActivity);

}
