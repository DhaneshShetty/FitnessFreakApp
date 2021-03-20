package com.ddevs.getfit

import android.app.Activity
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.fitness.Fitness
import com.google.android.gms.fitness.HistoryClient
import com.google.android.gms.fitness.data.DataSet
import com.google.android.gms.fitness.data.DataType
import com.google.android.gms.fitness.data.Field.FIELD_STEPS
import com.google.android.gms.fitness.request.DataReadRequest
import com.google.android.gms.fitness.result.DataReadResponse
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS


class ProfileViewModel(val context: Activity) : ViewModel() {
    private  var _name: MutableLiveData<String> = MutableLiveData()
    private  var _email:MutableLiveData<String> = MutableLiveData()
    private  var _dp:MutableLiveData<Uri> = MutableLiveData()
    var name:LiveData<String> =_name
    var email:LiveData<String> =_email
    var dp:LiveData<Uri> =_dp
    var onSignOut:MutableLiveData<Boolean> = MutableLiveData(false)

    fun fetchUserData(){
        val user:FirebaseUser?=FirebaseAuth.getInstance().currentUser
        _name.value=user?.displayName
        _email.value=user?.email
        _dp.value= user?.photoUrl
        Log.d("Value", email.toString())
    }
    fun logOut(){
        FirebaseAuth.getInstance().signOut()
        onSignOut.value=true

    }
    fun fetchFromGoogleAPI() {
        val historyClient: HistoryClient =
            Fitness.getHistoryClient(context, GoogleSignIn.getLastSignedInAccount(context)!!)
        Log.e("API", "data")

    }




}