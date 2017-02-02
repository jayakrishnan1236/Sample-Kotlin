package kot.mvp




/**
 * Created by user on 2/2/2017.
 */
interface Presenter<Any: MvpView>{

    fun attachView(mvpView: Any)
    fun detachView()
    
}