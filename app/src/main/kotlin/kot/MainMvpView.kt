package kot

import kot.mvp.BaseNetworkMvpView
import kot.mvp.MvpView

/**
 * Created by user on 2/2/2017.
 */

interface MainMvpView : BaseNetworkMvpView {

    override fun showProgress(show: Boolean)

    override fun showError(show: Boolean)

}
