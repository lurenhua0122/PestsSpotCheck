package cn.com.aiton.pestsspotcheck.data.resposity

import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl
import cn.com.aiton.pestsspotcheck.data.local.SpotCheckControlDao
import cn.com.aiton.pestsspotcheck.data.web.SpotCheckControlWebData
import cn.com.aiton.pestsspotcheck.utils.performGetOperation
import javax.inject.Inject

class SpotCheckControlRepository @Inject constructor(
    private val webDataSource: SpotCheckControlWebData,
    private val localDataSource: SpotCheckControlDao
) {
    fun getSpotCheck(){
        var s_1 = SpotCheckControl("1", "s1", "小学","11.1","11.2","10","10"
        ,"http","http","http","xm","xi","lurenhua","01","020","123123123213123123","1213123123",0,true,
        "2123","2131321","123123","123123","123123","2131312")
        var s_2 = SpotCheckControl("1", "s1", "小学","11.1","11.2","10","10"
            ,"http","http","http","xm","xi","lurenhua","01","020","123123123213123123","1213123123",0,true,
            "2123","2131321","123123","123123","123123","2131312")
        var sList: MutableList<SpotCheckControl> = mutableListOf<SpotCheckControl>()

        sList.add(s_1)
        sList.add(s_2)
        localDataSource.insertAll(sList)

        var sList_select_1: MutableList<SpotCheckControl> = localDataSource.getAllStudents()
        for (i in sList_select_1.indices) {
            println(sList_select_1.get(i))
        }
    }
//    fun getImage(id: String) = performGetOperation(

//        databaseQuery = { localDataSource.getAllByDateDesc(id) },
//        networkCall = { webDataSource.getImage() },
//        saveCallResult = {
//            if (it.data.isNotEmpty())
//                localDataSource.insert(it.data[0])
//        }
//    )

//    fun getImages() = performGetOperation(
//        databaseQuery = { localDataSource.getAllImages() },
//        networkCall = { webDataSource.getImages() },
//        saveCallResult = { localDataSource.insertAll(it.data) }
//    )
}