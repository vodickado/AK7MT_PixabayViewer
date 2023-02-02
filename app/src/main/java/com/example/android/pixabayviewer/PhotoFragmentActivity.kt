package com.example.android.pixabayviewer

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.pixabayviewer.databinding.FragmentPhotoBinding
import com.example.android.pixabayviewer.models.Hit
import com.example.android.pixabayviewer.overview.OverviewViewModel
import com.example.android.pixabayviewer.overview.PhotoGridAdapter

class PhotoFragmentActivity: AppCompatActivity() {

    private lateinit var binding: FragmentPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_photo)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_photo)

        val item: Hit? =OverviewViewModel.activeItem.value
        binding.photo = item

        val actionbar = supportActionBar

        actionbar!!.title =item?.tags.toString()

        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}