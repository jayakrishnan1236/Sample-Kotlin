package kot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.webappclouds.samplekotlin.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainMvpView {

    @Inject
    lateinit var presenter: MainPresenter /*startActivityResult -> setResult(intent.(int String)) finish -> onActivitResult intent -> int string*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainApplication.appComponent.inject(this)
        presenter.attachView(this)

        presenter.loadItems()
    }

    override fun showError(show: Boolean) {

    }

    override fun showProgress(show: Boolean) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
