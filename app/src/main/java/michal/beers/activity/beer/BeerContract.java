package michal.beers.activity.beer;

import java.util.List;

import michal.beers.data.Beer;

public interface BeerContract {

    interface View {
        void showError();

        void showData(List<Beer> beers);
    }

    interface Presenter {
        void getBeer();
    }


}
