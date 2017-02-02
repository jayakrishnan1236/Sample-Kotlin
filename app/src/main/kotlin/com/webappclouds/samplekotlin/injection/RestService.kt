package kt.injection

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Url

import rx.Observable

/**
 * Created by user on 2/2/2017.
 */
interface RestService {


    @GET
    fun getSampleJson(@Url url:String): Observable<JsonObject>
}