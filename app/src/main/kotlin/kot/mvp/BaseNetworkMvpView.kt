package kot.mvp

/**
 * Created by user on 2/2/2017.
 */

interface BaseNetworkMvpView : MvpView {

    fun showProgress(show: Boolean)

    fun showError(show: Boolean)

}
