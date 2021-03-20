package com.ddevs.getfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.HistoryClient
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.Field
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val historyClient:HistoryClient= Fitness.getHistoryClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
        val textView:TextView=findViewById(R.id.data)
        historyClient.readDailyTotal(DataType.TYPE_MOVE_MINUTES).addOnCompleteListener { result->
            val ans=result.result?.dataPoints?.firstOrNull()?.getValue(Field.FIELD_STEPS)?.asInt() ?: 0
            textView.text = ans.toString()
        }*/
    }
}