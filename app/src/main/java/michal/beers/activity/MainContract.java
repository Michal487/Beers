package michal.beers.activity;

import java.util.List;

import michal.beers.data.Beer;

public interface MainContract {

    interface View {
        void showError();

        void showData(List<Beer> beers);
    }

    interface Presenter {
        void getBeer();
    }


}
