package michal.beers.activity.details;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import michal.beers.api.Api;
import michal.beers.dao.BeerDao;
import michal.beers.data.Beer;

public class DetailsPresenter implements DetailsContract.Presenter, LifecycleObserver {

    private DetailsContract.View view;
    private String beerId;
    private BeerDao beerDao;

    public DetailsPresenter(DetailsContract.View view, BeerDao beerDao) {
        this.view = view;
        this.beerDao = beerDao;

        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @Override
    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void getDetailsForBeer() {

        view.showImage(beerDao.getBeerById(beerId).getImageUrl());
        view.showTitle(beerDao.getBeerById(beerId).getName());
        view.showDescription(beerDao.getBeerById(beerId).getDescription());

    }

}
