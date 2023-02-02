package com.example.android.pixabayviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.pixabayviewer.databinding.FragmentPhotoBinding
import com.example.android.pixabayviewer.models.Hit
import com.example.android.pixabayviewer.overview.OverviewViewModel

class SettingsActivity:AppCompatActivity() {
    //private lateinit var binding: FragmentPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        setContentView(R.layout.fragment_settings)
        //binding = DataBindingUtil.setContentView(this, R.layout.fragment_settings)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.title="Settings"
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}