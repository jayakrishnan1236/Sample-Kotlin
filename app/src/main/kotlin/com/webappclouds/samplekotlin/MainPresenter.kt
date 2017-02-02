package com.webappclouds.samplekotlin

import android.util.Log
import com.google.gson.JsonObject
import kt.constants.LINK
import kt.constants.LOCATION_KEY
import kt.injection.RestService
import kt.mvp.BasePresenter
import kt.utils.PreferencesHelper
import kt.utils.io
import kt.utils.unsubsribe
import org.json.JSONObject
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by user on 2/2/2017.
 */

class MainPresenter @Inject constructor(var prefHelper: PreferencesHelper
                                        , var restService: RestService) : BasePresenter<MainMvpView>() {

    private var subsription: Subscription? = null

    fun loadItems() {
        val cityName: String

        if (prefHelper.isKey(LOCATION_KEY)) {
            cityName = prefHelper.getString(LOCATION_KEY)
        } else {
            cityName = "Hyderabad"
        }

        if(isViewAttached()) getMvpView()!!.showProgress(true)
        else Timber.e("mvp view is null")

        subsription = io(restService.getSampleJson(LINK))
                .subscribe(object: Subscriber<JsonObject>(){
                    override fun onCompleted() {
                        getMvpView()!!.showProgress(false)
                    }

                    override fun onError(e: Throwable?) {
                        Timber.e(e)
                        getMvpView()!!.showError(true)
                    }

                    override fun onNext(t: JsonObject?) {
                        println(t.toString())
                    }

                })
    }

    override fun detachView() {
        super.detachView()
        unsubsribe(subsription)
    }

}