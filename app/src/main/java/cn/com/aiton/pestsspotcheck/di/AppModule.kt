package cn.com.aiton.pestsspotcheck.di

import android.content.Context
import cn.com.aiton.pestsspotcheck.data.local.SpotCheckControlDao
import cn.com.aiton.pestsspotcheck.data.local.SpotCheckDatabase
import cn.com.aiton.pestsspotcheck.data.resposity.SpotCheckControlRepository
import cn.com.aiton.pestsspotcheck.data.web.SpotCheckControlService
import cn.com.aiton.pestsspotcheck.data.web.SpotCheckControlWebData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author: ffzs
 * @Date: 2020/9/12 下午2:34
 */

@Module  // 注释该对象以指示我们将从此处获取依赖项
@InstallIn(ApplicationComponent::class)  // 组件的层级
object AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton  // 唯一实例
    @Provides  // 通过 @Provides注入， 还可以通过@Binds，使用场景不同
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://gank.io/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideSpotCheckControlService(retrofit: Retrofit): SpotCheckControlService = retrofit.create(SpotCheckControlService::class.java)

    @Singleton
    @Provides
    fun provideSpotCheckControlRemoteDataSource(SpotCheckControlService: SpotCheckControlService):SpotCheckControlWebData = SpotCheckControlWebData(SpotCheckControlService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): SpotCheckDatabase = SpotCheckDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideSpotCheckControlDao(db: SpotCheckDatabase): SpotCheckControlDao = db.controlDao

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: SpotCheckControlWebData,
                          localDataSource: SpotCheckControlDao) =
        SpotCheckControlRepository(remoteDataSource, localDataSource)
}

