package michal.beers.api;

import java.util.List;

import io.reactivex.Single;
import michal.beers.data.Beer;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.punkapi.com/v2/";

    @GET("beers")
    Single<List<Beer>> getBeers();


}
