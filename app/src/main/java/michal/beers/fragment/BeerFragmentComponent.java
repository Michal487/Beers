package michal.beers.fragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = BeerFragmentModule.class)
public interface BeerFragmentComponent {

    void inject(BeerFragment detailsFragment);

}
