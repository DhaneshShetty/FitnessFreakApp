package com.ddevs.getfit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.ddevs.getfit.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var profileBinding: FragmentProfileBinding
    lateinit var viewModel:ProfileViewModel
   

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        viewModel= ViewModelProvider(this,ProfileViewModelFactory(requireActivity())).get(ProfileViewModel::class.java)
        profileBinding.viewModel=viewModel
        viewModel.fetchUserData()
        viewModel.fetchFromGoogleAPI()
        viewModel.dp.observe(viewLifecycleOwner, {
            Glide.with(this)
                    .load(it).placeholder(R.drawable.ic_baseline_account_circle_24)
                    .circleCrop()
                    .into(profileBinding.profileImage)
        })
        viewModel.onSignOut.observe(viewLifecycleOwner,{
            if(it){
                startActivity(Intent(activity,LoginActivity::class.java))
            }
        })
        return profileBinding.root
    }

}