package com.webappclouds.samplekotlin;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import kot.injection.RestService;
import kot.utils.RxUtilKt;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by user on 2/1/2017.
 */

public class SampleClass extends SampleParent implements SampleInterface{

    @Inject RestService restService;

    public void sample(){
        Subscription subscription = RxUtilKt.io(restService.getSampleJson("google.com"))
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JsonObject jsonObject) {

                    }
                });
    }

}
