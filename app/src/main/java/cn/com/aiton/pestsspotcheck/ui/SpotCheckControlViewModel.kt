package cn.com.aiton.pestsspotcheck.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl
import cn.com.aiton.pestsspotcheck.data.resposity.SpotCheckControlRepository
import cn.com.aiton.pestsspotcheck.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext

class SpotCheckControlViewModel   @ViewModelInject constructor(
    @ApplicationContext private val repository: SpotCheckControlRepository
) : ViewModel() {

    private val _id = MutableLiveData<SpotCheckControl>()

    private val _image = _id.switchMap { id ->
        repository.getSpotCheck()
    }
    val image: LiveData<Resource<SpotCheckControl>> = _image

    fun start(id: String) {
        _id.value = id
    }

}