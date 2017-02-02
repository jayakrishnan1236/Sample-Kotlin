package kot.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.squareup.picasso.Picasso
import com.webappclouds.samplekotlin.BuildConfig
import dagger.Module
import dagger.Provides
import kot.utils.PreferencesHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by user on 2/2/2017.
 */

@Module
class AppModule @Inject constructor(val baseUrl: String, val application: Application) {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }

        return Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun providePicasso(context: Context): Picasso = Picasso.with(context)

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences
            = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideRestService(retrofit: Retrofit): RestService = retrofit.create(RestService::class.java)
}