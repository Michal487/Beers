package michal.beers.fragment;

public class BeerFragmentPresenter implements BeerFragmentContract.Presenter {

    private BeerFragmentContract.View view;

    public BeerFragmentPresenter(BeerFragmentContract.View view) {
        this.view = view;
    }
}
