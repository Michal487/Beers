package michal.beers.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import michal.beers.api.Api;
import michal.beers.dao.BeerDao;
import michal.beers.data.Beer;

public class BeerPresenter implements BeerContract.Presenter, LifecycleObserver {

    private BeerContract.View view;
    private Api api;
    private BeerDao beerDao;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public BeerPresenter(BeerContract.View view, Api api, BeerDao beerDao) {
        this.view = view;
        this.api = api;
        this.beerDao = beerDao;

        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        getBeer();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        compositeDisposable.clear();
    }

    @Override
    public void getBeer() {

        if (beerDao.getAll().isEmpty()) {
            compositeDisposable.add(
                    api.getBeers()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    beers -> {
                                        view.showData(beers);
                                        beerDao.insert(beers);
                                    },
                                    throwable -> view.showError()
                            )
            );
        } else {
            view.showData(beerDao.getAll());
        }
    }

}
