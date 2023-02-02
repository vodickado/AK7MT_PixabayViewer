/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.pixabayviewer

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.pixabayviewer.overview.OverviewViewModel


//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


/**
 * MainActivity sets the content view activity_main, a fragment container that contains
 * overviewFragment.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchView = menu.findItem(R.id.action_search).actionView as SearchView?
        searchView!!.maxWidth = Int.MAX_VALUE


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String): Boolean {
                Log.i("LUL",query);
                setQuery(query);
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("LUL2",query);
                setQuery(query);
                return false
            }

        })


        searchView.setOnCloseListener(SearchView.OnCloseListener {
            Log.i(TAG, "mSearchView on close ")
            setQuery("");
            false
        })





/*
        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
*/
        return true
    }

    private fun setQuery(query:String){
        OverviewViewModel.currentPage.value=1;
        OverviewViewModel.toSearch.value=query;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            // do something here
            Log.i("lul",id.toString())
            //OverviewViewModel.activeItem.value=photo

            val myIntent = Intent(this, SettingsActivity::class.java)
            //myIntent.putExtra("key", value) //Optional parameters

            this?.startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showToast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

}