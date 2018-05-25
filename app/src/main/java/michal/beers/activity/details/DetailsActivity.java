package michal.beers.activity.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import michal.beers.BeerApplication;
import michal.beers.R;
import michal.beers.data.Beer;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    public static final String KEY_BEER_ID = "beerId";


    @Inject
    DetailsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        ((BeerApplication) getApplication())
                .getAppComponent()
                .plus(new DetailsModule(this))
                .inject(this);


        presenter.setBeerId(getIntent().getStringExtra(KEY_BEER_ID));


    }

}
