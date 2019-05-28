package kz.seruen.Services

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class Place(var id:String?=null,
            var name:String?=null,
            var averCost:Double?=null,
            var address:String?=null,
            var workDay:String?=null,
            var workHour:String?=null,
            var image:String?=null,
            var shortInf:String?=null,
            var type:String?=null)