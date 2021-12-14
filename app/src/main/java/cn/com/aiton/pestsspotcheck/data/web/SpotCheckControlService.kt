package cn.com.aiton.pestsspotcheck.data.web

import android.media.Image
import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl
import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControlList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SpotCheckControlService {
    @GET("random/category/{category}/type/{type}/count/{count}")
    suspend fun getInfo(
        @Path("category") category: String,
        @Path("type") type: String,
        @Path("count") count: Int
    ) : Response<List<SpotCheckControl>>


    @GET("random/category/Girl/type/Girl/count/20")
    suspend fun getImages() : Response<SpotCheckControlList>

    @GET("random/category/Girl/type/Girl/count/1")
    suspend fun getImage() : Response<SpotCheckControlList>

}