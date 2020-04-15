package favoris

import retrofit2.Call
import retrofit2.http.GET

interface HtppBinServiceString {

    @GET("get")
    fun getUserAgent() : Call<GetData>
}