package michal.beers.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import michal.beers.BeerApplication;
import michal.beers.R;
import michal.beers.api.Api;
import michal.beers.data.Beer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeerActivity extends AppCompatActivity implements BeerContract.View {

    @Inject
    BeerContract.Presenter presenter;

    private BeerAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        ((BeerApplication) getApplication())
                .getAppComponent()
                .plus(new BeerModule(this))
                .inject(this);

        presenter.getBeer();

        adapter = new BeerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError() {
        Log.e("ERROR", "Error");
    }

    @Override
    public void showData(List<Beer> beers) {
        adapter.updateBeers(beers);
    }
}
