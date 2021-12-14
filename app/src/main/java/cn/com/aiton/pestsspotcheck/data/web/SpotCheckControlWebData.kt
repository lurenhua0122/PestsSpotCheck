package cn.com.aiton.pestsspotcheck.data.web

import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl
import javax.inject.Inject

class SpotCheckControlWebData @Inject constructor(
    private val imageService: SpotCheckControlService,
) : SpotCheckControlDataSource() {

    suspend fun getImages() = getResult { imageService.getImages() }
    suspend fun getImage() = getResult { imageService.getImage() }
    suspend fun getInfo(
        category: String,
        type: String,
        count: Int,
    ) = getResult { imageService.getInfo(category, type, count) }
}