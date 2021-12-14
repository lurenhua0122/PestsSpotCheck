package cn.com.aiton.pestsspotcheck.data.web

import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControlList
import cn.com.aiton.pestsspotcheck.utils.Resource
import retrofit2.Response
import timber.log.Timber

abstract class SpotCheckControlDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                body as SpotCheckControlList
                // 将api获取的图片信息中http换为https不然无法完成跳转
                body.data.map {
                    it.fellPic = it.fellPic.replace("http://", "https://")
                    it.finishPic = it.finishPic.replace("http://", "https://")
                    it.stumpPic = it.stumpPic.replace("http://", "https://")
                }
                Timber.i(body.toString())
                return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)
        return Resource.error("访问出错: $message")
    }
}