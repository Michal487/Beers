package michal.beers.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import michal.beers.api.Api;

public class MainPresenter implements MainContract.Presenter, LifecycleObserver {

    private MainContract.View view;
    private Api api;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainPresenter(MainContract.View view, Api api) {
        this.view = view;
        this.api = api;

        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        getBeer();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        compositeDisposable.clear();
    }

    @Override
    public void getBeer() {
        compositeDisposable.add(
                api.getBeers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                beers -> view.showData(beers),
                                throwable -> view.showError()
                        )
        );
    }

}
