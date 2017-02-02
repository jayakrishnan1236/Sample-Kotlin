package kot

import kot.injection.RestService
import kot.mvp.BasePresenter
import kot.utils.PreferencesHelper
import kot.utils.unsubsribe
import rx.Subscription
import javax.inject.Inject

/**
 * Created by user on 2/2/2017.
 */

class MainPresenter @Inject constructor(var prefHelper: PreferencesHelper
                                        , var restService: RestService) : BasePresenter<MainMvpView>() {

    private var subsription: Subscription? = null

    fun loadItems() {
        var cityName: String? = null

    }

    override fun detachView() {
        super.detachView()
        unsubsribe(subsription)
    }

}