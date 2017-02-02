package kot.injection

import dagger.Component
import kot.MainActivity
import javax.inject.Singleton

/**
 * Created by user on 2/2/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}