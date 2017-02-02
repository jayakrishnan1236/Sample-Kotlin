package com.webappclouds.samplekotlin

import android.app.Application;
import android.content.Context

import kt.injection.AppComponent;
import kt.injection.AppModule
import kt.injection.DaggerAppComponent

/**
 * Created by user on 2/2/2017.
 */

class MainApplication: Application() {

    /*companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: AppComponent
    }*/
    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule("http://www.google.com/", this))
                .build()
    }

}
