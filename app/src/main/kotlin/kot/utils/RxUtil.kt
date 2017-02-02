package kot.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx.Subscription

/**
 * Created by user on 2/2/2017.
 */

fun unsubsribe(subscription: Subscription?) {
    if (subscription != null && !subscription.isUnsubscribed) {
        subscription.unsubscribe()
    }
}

fun io(obs: Observable<Any>){
    obs.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
}
