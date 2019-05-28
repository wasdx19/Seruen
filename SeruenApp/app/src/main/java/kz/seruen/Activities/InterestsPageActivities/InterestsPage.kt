package kz.seruen.Activities.InterestsPageActivities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp

import kz.seruen.Activities.MainActivity
import kz.seruen.R
import kz.seruen.Utils.DBUtilsFb

class InterestsPage : AppCompatActivity() {
    internal lateinit var accept: Button
    private var cvNature:CardView?=null
    private var cvPark:CardView?=null
    private var cvCafe:CardView?=null
    private var cvNightClub:CardView?=null
    private var cvBar:CardView?=null
    private var cvMuseum:CardView?=null
    private var cvCircuit:CardView?=null
    private var cvZoo:CardView?=null
    private var cvRestourant:CardView?=null
    private var cvTheatre:CardView?=null
    private var cvTraditional:CardView?=null
    private var cvShowplace:CardView?=null

    private var ivNature:ImageView?=null
    private var ivPark:ImageView?=null
    private var ivCafe:ImageView?=null
    private var ivNightClub:ImageView?=null
    private var ivBar:ImageView?=null
    private var ivMuseum:ImageView?=null
    private var ivCircuit:ImageView?=null
    private var ivZoo:ImageView?=null
    private var ivRestourant:ImageView?=null
    private var ivTheatre:ImageView?=null
    private var ivTraditional:ImageView?=null
    private var ivShowplace:ImageView?=null

    private var tvNature:TextView?=null
    private var tvPark:TextView?=null
    private var tvCafe:TextView?=null
    private var tvNightClub:TextView?=null
    private var tvBar:TextView?=null
    private var tvMuseum:TextView?=null
    private var tvCircuit:TextView?=null
    private var tvZoo:TextView?=null
    private var tvRestourant:TextView?=null
    private var tvTheatre:TextView?=null
    private var tvTraditional:TextView?=null
    private var tvShowPlace:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interests_page)

        builtView()

        var checkedInterest:ArrayList<String>?= arrayListOf()


        cvZoo?.setOnClickListener { v: View? ->
            val check=showHide(ivZoo)
            if(check==true){
                checkedInterest!!.add(tvZoo?.text.toString())
            }else{
                checkedInterest!!.remove(tvZoo?.text.toString())
            }
        }

        cvTraditional?.setOnClickListener { v: View? ->
            val check=showHide(ivTraditional)
            if(check==true){
                checkedInterest!!.add(tvTraditional?.text.toString())
            }else{
                checkedInterest!!.remove(tvTraditional?.text.toString())
            }
        }

        cvTheatre?.setOnClickListener { v: View? ->
            val check=showHide(ivTheatre)
            if(check==true){
                checkedInterest!!.add(tvTheatre?.text.toString())
            }else{
                checkedInterest!!.remove(tvTheatre?.text.toString())
            }
        }

        cvShowplace?.setOnClickListener { v: View? ->
            val check=showHide(ivShowplace)
            if(check==true){
                checkedInterest!!.add(tvShowPlace?.text.toString())
            }else{
                checkedInterest!!.remove(tvShowPlace?.text.toString())
            }
        }

        cvRestourant?.setOnClickListener { v: View? ->
            val check=showHide(ivRestourant)
            if(check==true){
                checkedInterest!!.add(tvRestourant?.text.toString())
            }else{
                checkedInterest!!.remove(tvRestourant?.text.toString())
            }
        }

        cvPark?.setOnClickListener { v: View? ->
            val check=showHide(ivPark)
            if(check==true){
                checkedInterest!!.add(tvPark?.text.toString())
            }else{
                checkedInterest!!.remove(tvPark?.text.toString())
            }
        }

        cvNightClub?.setOnClickListener { v: View? ->
            val check=showHide(ivNightClub)
            if(check==true){
                checkedInterest!!.add(tvNightClub?.text.toString())
            }else{
                checkedInterest!!.remove(tvNightClub?.text.toString())
            }
        }

        cvNature?.setOnClickListener { v: View? ->
            val check=showHide(ivNature)
            if(check==true){
                checkedInterest!!.add(tvNature?.text.toString())
            }else{
                checkedInterest!!.remove(tvNature?.text.toString())
            }
        }

        cvMuseum?.setOnClickListener { v: View? ->
            val check=showHide(ivMuseum)
            if(check==true){
                checkedInterest!!.add(tvMuseum?.text.toString())
            }else{
                checkedInterest!!.remove(tvMuseum?.text.toString())
            }
        }

        cvCircuit?.setOnClickListener { v: View? ->
            val check=showHide(ivCircuit)
            if(check==true){
                checkedInterest!!.add(tvCircuit?.text.toString())
            }else{
                checkedInterest!!.remove(tvCircuit?.text.toString())
            }
        }

        cvCafe?.setOnClickListener { v: View? ->
            val check=showHide(ivCafe)
            if(check==true){
                checkedInterest!!.add(tvCafe?.text.toString())
            }else{
                checkedInterest!!.remove(tvCafe?.text.toString())
            }
        }

        cvBar?.setOnClickListener { v: View? ->
            val check=showHide(ivBar)
            if(check==true){
                checkedInterest!!.add(tvBar?.text.toString())
            }else{
                checkedInterest!!.remove(tvBar?.text.toString())
            }
        }


        accept.setOnClickListener {
            var userId=FirebaseApp.getInstance()?.uid
            if(userId!=null){
                for(i in checkedInterest!!.iterator()) {
                    DBUtilsFb.addUserInterest(userId, i)
                }
            }
            val intent = Intent(this@InterestsPage, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }

    private fun builtView(){
        accept = findViewById(R.id.button_ok)
        cvBar=findViewById(R.id.cv_bar)
        cvCafe=findViewById(R.id.cv_cafe)
        cvCircuit=findViewById(R.id.cv_circuit)
        cvMuseum=findViewById(R.id.cv_museum)
        cvNature=findViewById(R.id.cv_nature)
        cvNightClub=findViewById(R.id.cv_nightClub)
        cvPark=findViewById(R.id.cv_park)
        cvRestourant=findViewById(R.id.cv_restoran)
        cvShowplace=findViewById(R.id.cv_showplaces)
        cvTheatre=findViewById(R.id.cv_theatre)
        cvTraditional=findViewById(R.id.cv_kTraditional)
        cvZoo=findViewById(R.id.cv_zoo)

        ivBar=findViewById(R.id.iv_bar)
        ivCafe=findViewById(R.id.iv_cafe)
        ivCircuit=findViewById(R.id.iv_circuit)
        ivMuseum=findViewById(R.id.iv_museum)
        ivNature=findViewById(R.id.iv_nature)
        ivNightClub=findViewById(R.id.iv_nightClub)
        ivPark=findViewById(R.id.iv_park)
        ivRestourant=findViewById(R.id.iv_restoran)
        ivShowplace=findViewById(R.id.iv_showPlaces)
        ivTheatre=findViewById(R.id.iv_theatre)
        ivTraditional=findViewById(R.id.iv_kTraditional)
        ivZoo=findViewById(R.id.iv_zoo)

        tvNature=findViewById(R.id.tv_nature)
        tvBar=findViewById(R.id.tv_bar)
        tvCafe=findViewById(R.id.tv_cafe)
        tvCircuit=findViewById(R.id.tv_circuit)
        tvMuseum=findViewById(R.id.tv_museum)
        tvNightClub=findViewById(R.id.tv_nightClub)
        tvPark=findViewById(R.id.tv_park)
        tvRestourant=findViewById(R.id.tv_restoran)
        tvShowPlace=findViewById(R.id.tv_showplaces)
        tvTraditional=findViewById(R.id.tv_kTraditional)
        tvTheatre=findViewById(R.id.tv_theatre)
        tvZoo=findViewById(R.id.tv_zoo)
    }

    fun showHide(view:ImageView?):Boolean {
        var check:Boolean?=false
        view?.visibility = if (view?.visibility == View.VISIBLE){
            check=false
            ImageView.INVISIBLE
        } else{
            check=true
            ImageView.VISIBLE
        }
        return check
    }

    fun showToast(message:String?){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
