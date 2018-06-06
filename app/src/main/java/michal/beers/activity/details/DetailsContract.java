package michal.beers.activity.details;

import java.util.List;

import io.reactivex.Single;
import michal.beers.data.Beer;

public interface DetailsContract {

    interface View {

        void showDescription(String description);

        void showImage(String image);

        void showTitle(String name);
    }

    interface Presenter {
        void setBeerId(String beerId);
    }

}
