package kt.injection

import dagger.Component
import kt.MainActivity
import javax.inject.Singleton

/**
 * Created by user on 2/2/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}