package com.example.blackholecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calc(view:View){
        var buSelect= view as Button
        when(buSelect.id){
            bu1.id->{
                if(t2.text.toString()==""&&t3.text.toString()!=""){
                    var ab=t3.text.toString()
                    var bc:Double=(6733257258) * ab.toDouble() //10^15 has to be printed
                    var ch=0
                    var dc:Double=0.0
                    while(bc.toInt()!=0){
                        ch++
                        dc=bc
                        bc=bc/10
                    }
                    ch+=15
                    t1.setText("your mass is "+dc+("10^")+ch+"\n")
                    var time=(bc*1.25)/2
                    ch=ch-71
                    t1.setText("your time it will last is "+dc+("10^")+ch)
                }
                else if(t3.text.toString()==""&&t2.text.toString()!="")
                {
                    var ab=t2.text.toString()
                    var bc:Double= ab.toDouble()/(6733257258) //10^15 has to be printed
                    var ch=0
                    var dc:Double=0.0
                    while(bc.toInt()<=0){
                        ch++
                        dc=bc
                        bc=bc*10.0
                    }
                    ch +=26

                    t1.setText("your radius is "+dc+("10^-")+ch+"\n")
                    var time=(bc*1.25)/2
                    ch=ch-71
                    t1.setText("your time it will last is "+dc+("10^-")+ch)
                }
                else{
                    var ab = t2.text.toString()
                    var bc= t3.text.toString()
                    var dc= ((ab.toDouble())/(bc.toDouble()))/10000000000
                    if(dc.toLong()>= 6733257258000){
                        t1.setText("your value satisfy the black hole criteria")
                        var ch=0
                        var dc=0.0
                        while(bc.toInt()<=0){
                            ch++
                            dc=bc.toDouble()
                            bc= ((bc.toDouble())*10.0).toString()
                        }
                        ch=ch-71
                        var time=(bc.toDouble()*1.25)/2

                        t1.setText("the life time of the object would be"+time+"10^"+ch)

                    }
                    else{
                        t1.setText("your given values does not satisfy the black hole criteria")
                    }
                }

            }
            b2.id->
            {
                t1.setText("")
                t2.setText("")
                t3.setText("")
            }
            b3.id->{
                exitProcess(0)
            }
        }

    }
}
