package kt.mvp

/**
 * Created by user on 2/2/2017.
 */
open class BasePresenter<Any: MvpView> : Presenter<Any> {

    private var mvpView:Any? = null

    override fun attachView(mvpView: Any) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
    }


    fun getMvpView(): Any? = mvpView

    fun isViewAttached():Boolean = mvpView!=null

}

