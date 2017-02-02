package com.webappclouds.samplekotlin

import kt.mvp.BaseNetworkMvpView
import kt.mvp.MvpView

/**
 * Created by user on 2/2/2017.
 */

interface MainMvpView : BaseNetworkMvpView {

    override fun showProgress(show: Boolean)

    override fun showError(show: Boolean)

}
