package kt.utils

import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by user on 2/2/2017.
 */

fun unsubsribe(subscription: Subscription?) {
    if (subscription != null && !subscription.isUnsubscribed) {
        subscription.unsubscribe()
    }
}

fun <T> io(obs: Observable<T>) : Observable<T> {
    return obs.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
}
