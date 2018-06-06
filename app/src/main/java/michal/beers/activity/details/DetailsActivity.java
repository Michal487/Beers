package michal.beers.activity.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import michal.beers.BeerApplication;
import michal.beers.R;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    public static final String KEY_BEER_ID = "beerId";

    @Inject
    DetailsContract.Presenter presenter;


    @BindView(R.id.details_textView)
    TextView details;

    @BindView(R.id.details_image)
    ImageView imageView;

    @BindView(R.id.details_title)
    TextView title;

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

    @Override
    public void showTitle(String name) {
        title.setText(name);
    }

    @Override
    public void showImage(String image) {
        Glide.with(imageView.getContext())
                .load(image)
                .into(imageView);
    }

    @Override
    public void showDescription(String description) {
        details.setText(description);
    }


}
