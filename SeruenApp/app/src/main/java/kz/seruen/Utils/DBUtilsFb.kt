package kz.seruen.Utils

import android.support.v7.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kz.seruen.Services.Interest
import kz.seruen.Services.Place
import kz.seruen.Services.Trip
import kz.seruen.Services.User

object DBUtilsFb{

    private val firebase: FirebaseDatabase by lazy{
        val db=FirebaseDatabase.getInstance()
        db
    }

    fun addUser(userId: String){
        val ref= firebase.getReference("Users")

        val user=User(userId,null,null)
        ref.child(userId).setValue(user)
    }

    fun addInterest(name:String){
        val ref= firebase.getReference("Interests")
        val interestId=ref.push().key

        val interest=Interest(interestId,name)

        ref.child(interestId!!).setValue(interest)
    }

    fun addUserInterest(userId:String,interstName:String){
        val ref= firebase.getReference("Users").child(userId).child("Interests")
        val interestId=ref.push().key

        val interest=Interest(interestId,interstName)

        ref.child(interestId!!).setValue(interest)
    }

    fun addPlace(name: String,averCost:Double,address:String,workDay:String,workHour:String,image:String,shortInf:String,type:String){
        val ref= firebase.getReference("Places")
        val placeId=ref.push().key

        val place=Place(placeId,name,averCost,address,workDay,workHour,image,shortInf,type)
        ref.child(placeId!!).setValue(place)
    }






//    fun getInterests():MutableList<Interest>?{
//        val ref= firebase.getReference("Interests")
//
//        var interests:MutableList<Interest>?= mutableListOf()
//        var interestList:ArrayList<String>?= arrayListOf()
//
//        ref.addValueEventListener(object:ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//            override fun onDataChange(p0: DataSnapshot) {
//                if(p0.exists()){
//                    for(interest in p0.children){
//                        val inter=interest.getValue(Interest::class.java)
//                        interests?.add(inter!!)
//                    }
//                }
//            }
//        })
//
//        return interests
//    }



//    fun addInterests(): Boolean? {
//        var comp:Boolean?=null
//        val ref= firebase.getReference("Interests")
//        val interstId=ref.push().key
//
//
//        val interest=Interest(interstId,"NightClub")
//
//        ref.child(interstId!!).setValue(interest)
//
//        ref.child(interstId!!).child("Places")
//        val placeId=ref.push().key
//
//        val placeList=ArrayList<Place>()
//        val place=Place()
//        place.id=placeId
//        place.name="SkyBar"
//        place.averCost=3000.0
//        place.address="Manasa 34"
//        place.workDay="Friday - Sunday"
//        place.workHour="20:00 - 05:00"
//        place.image="qwer"
//        place.shortInf="qqwerqqwerqqwerqqwerqqwerqqwer"
//
//        placeList.add(place)
//
//        ref.child(interstId!!).child("Places").setValue(placeList).addOnCompleteListener {
//            comp=true
//        }
//
//        return comp
//    }

//    fun addUser():Boolean?{
//        var comp:Boolean?=null
//
//        val ref= firebase.getReference("Users")
//        val userId=FirebaseApp.getInstance()?.uid
//
//        val user= User(userId,1,null)
//
//        ref.child(userId!!).setValue(user).addOnCompleteListener{
//            comp=true
//        }
//
//        return comp
//    }

    /*fun addUserTrip():Boolean?{
        var comp:Boolean?=null

        val userId=FirebaseApp.getInstance()?.uid
        val ref= firebase.getReference("Users").child(userId!!).child("Trips")

        val tripId=ref.push().key

        val placeList=ArrayList<Places>()
        val place=Places()
        place.id="2"
        place.name="SkyBar"
        place.averCost=3000.0
        place.address="Manasa 34"
        place.workDay="Friday - Sunday"
        place.workHour="20:00 - 05:00"
        place.image="qwer"
        place.shortInf="qqwerqqwerqqwerqqwerqqwerqqwer"

        placeList.add(place)
        val trip=Trip(tripId,3000.0,"17.05.2019",placeList)

        ref.child(tripId!!).setValue(trip).addOnCompleteListener {
            comp=true
        }

        return comp
    }*/
}
