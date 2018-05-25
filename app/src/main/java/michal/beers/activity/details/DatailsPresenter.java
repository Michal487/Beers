package michal.beers.activity.details;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

public class DatailsPresenter implements DetailsContract.Presenter, LifecycleObserver {

    private DetailsContract.View view;

    public DatailsPresenter(DetailsContract.View view) {
        this.view = view;

        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @Override
    public void setBeerId(String stringExtra) {

    }
}
