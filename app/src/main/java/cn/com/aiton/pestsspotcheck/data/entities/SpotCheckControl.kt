package cn.com.aiton.pestsspotcheck.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spot_check_control")
data class SpotCheckControl(
    @PrimaryKey
    var _id:String,
    var deviceId:String,
    var stime:String,
    var longitude:String,
    var latitude:String,
    var positionError:String,
    var treeWalk:String,
    var fellPic:String,
    var stumpPic:String,
    var finishPic:String,
    var town:String,
    var village:String,
    var _operator:String,
    var xb:String,
    var db:String,
    var qrcode:String,
    var projectId:String,
    var isDeleted:Int,
    var isChecked:Boolean,
    var gmtCreate:String,
    var gmtModified:String,
    var userId:String,
    var bagNumber:String,
    var appId:String,
    var pestsType:String,


)