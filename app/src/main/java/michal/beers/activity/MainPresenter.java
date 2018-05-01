package michal.beers.activity;

import android.arch.lifecycle.LifecycleObserver;

public class MainPresenter implements MainContract.Presenter, LifecycleObserver {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


}
