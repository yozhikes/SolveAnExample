package com.example.solveanexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var rght=0.00
    var wrng=0.00
    var ttl=0.00
    var prcnt=0.00
    var rndChislo= Random.nextInt(10,100)
    var rndznak= Random.nextInt(1,5)
    lateinit var right: TextView
    lateinit var percent: TextView
    lateinit var total: TextView
    lateinit var wrong: TextView
    lateinit var first: TextView
    lateinit var znak: TextView
    lateinit var second: TextView
    lateinit var vvod: TextView
    lateinit var btnCheck: TextView
    lateinit var btnStart: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        right=findViewById<TextView>(R.id.rightTxt)
        total=findViewById<TextView>(R.id.totalTxt)
        percent=findViewById<TextView>(R.id.percentTxt)
        wrong=findViewById<TextView>(R.id.wrongTxt)
        first=findViewById<TextView>(R.id.firstTxt)
        znak=findViewById<TextView>(R.id.znakTxt)
        second=findViewById<TextView>(R.id.secondTxt)
        vvod=findViewById<TextView>(R.id.vvodTxt)
        btnCheck=findViewById<TextView>(R.id.btn_Check)
        btnStart=findViewById<TextView>(R.id.btn_Start)
    }
    fun btn_Startfun(view: View){
        first.text=Random.nextInt(10,100).toString()
        second.text=Random.nextInt(10,100).toString()
        when(Random.nextInt(1,5)){
            1->znak.text="+"
            2->znak.text="-"
            3->znak.text="*"
            4->znak.text="/"
        }
        if(znak.text=="/"){
            if(((first.text.toString().toInt())%(second.text.toString().toInt()))!=0){
                znak.text="+"
            }
        }
        btnStart.isEnabled=false
        btnCheck.isEnabled=true
        vvod.isEnabled=true
        vvod.setBackgroundColor(Color.WHITE)
        vvod.text="0"
    }
    fun btn_CheckFun(view: View){
        var res=0
        when(znak.text.toString()){
            "+"->res=first.text.toString().toInt()+second.text.toString().toInt()
            "-"->res=first.text.toString().toInt()-second.text.toString().toInt()
            "*"->res=first.text.toString().toInt()*second.text.toString().toInt()
            "/"->res=first.text.toString().toInt()/second.text.toString().toInt()
        }
        if(res==vvod.text.toString().toInt()){
            vvod.setBackgroundColor(Color.GREEN)
            rght++
            right.text=rght.toInt().toString()
        }
        else{
            vvod.setBackgroundColor(Color.RED)
            wrng++
            wrong.text=wrng.toInt().toString()
        }
        ttl++
        total.text=ttl.toInt().toString()
        prcnt=rght/ttl*100
        percent.text= "${String.format("%.2f",prcnt)}%"
        vvod.isEnabled=false
        btnStart.isEnabled=true
        btnCheck.isEnabled=false
    }
}