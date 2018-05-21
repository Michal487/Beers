package michal.beers.activity;

import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import michal.beers.BeerApplication;
import michal.beers.R;
import michal.beers.data.Beer;

public class BeerActivity extends AppCompatActivity implements BeerContract.View {

    @Inject
    BeerContract.Presenter presenter;

    private BeerAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.errorGroup)
    Group errorGroup;

    @BindView(R.id.beer_swipeRefresh)
    SwipeRefreshLayout refreshLayout;

    @OnClick(R.id.errorButton)
    public void onTryAgainClick() {
        presenter.getBeer();
    }

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

        refreshLayout.setOnRefreshListener(()-> presenter.getBeer());

    }

    @Override
    public void showError() {
        errorGroup.setVisibility(View.VISIBLE);
        Log.e("ERROR", "Error");
    }

    @Override
    public void showData(List<Beer> beers) {
        adapter.updateBeers(beers);
        errorGroup.setVisibility(View.INVISIBLE);
        refreshLayout.setRefreshing(false);
    }
}
