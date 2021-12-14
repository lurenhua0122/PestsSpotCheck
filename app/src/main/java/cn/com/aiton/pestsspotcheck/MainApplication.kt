package cn.com.aiton.pestsspotcheck

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * @author: ffzs
 * @Date: 2020/9/12 下午2:15
 */
@HiltAndroidApp
class MainApplication:Application() {
    companion object {
        var instance: MainApplication by Delegates.notNull()
        fun instance() = instance
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

