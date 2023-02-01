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

package com.example.android.pixabayviewer.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.pixabayviewer.models.Hit
import com.example.android.pixabayviewer.models.PixRes
import com.example.android.pixabayviewer.network.PixApi
import com.example.android.pixabayviewer.network.PixPhoto
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


enum class PixApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<PixApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<PixApiStatus> = _status


    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _photos = MutableLiveData<List<Hit>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<Hit>> = _photos


    /*
    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _photos = MutableLiveData<PixRes>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<PixRes> = _photos
*/
    /**
     * Call getPixabayViewer() on init so we can display status immediately.
     */
    init {
        getPixabayViewer()
    }


    private var map: HashMap<String, String> = HashMap<String, String> ()

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [PixPhoto] [List] [LiveData].
     */


    //var retrofit: Retrofit? = null
    //var adapter: PhotoGridAdapter? = null

    private fun getPixabayViewer() {
        map = HashMap<String,String>()
        viewModelScope.launch {
            _status.value = PixApiStatus.LOADING
            try {
                map.put("key", "9827246-942760fad484a84884af4a848");
                map.put("q", "animal");
                map.put("image_type","all");
                map.put("page","1");



                /*
                Call<PixRes> call = retrofit.getService(PixRes.class).getImages(map);
                call.enqueue(new Callback<PixRes>() {
                    @Override
                    public void onResponse(Call<PixRes> call, Response<PixRes> response) {
                        PixRes pixabayResponse = response.body();
                        List<Hit> hits = pixabayResponse.getHits();
                        adapter = new PixabayAdapter(getApplicationContext(),hits);
                        rv.setAdapter(adapter);
                        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        currentPage = 1;
                    }

                    @Override
                    public void onFailure(Call<PixRes> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/




                var lul=PixApi.retrofitService.getImages(map)?.enqueue(object : Callback<PixRes?> {
                    override fun onResponse(call: Call<PixRes?>, response: Response<PixRes?>) {
                        if (response.isSuccessful) {
                            _photos.value = response.body()?.hits

                            _status.value = PixApiStatus.DONE
                            //callBack.onSuccess(response.body())
                        } else {
                            //callBack.onError(ErrorUtils.parseError(response))
                            Log.i("huh", "failed")
                        }
                    }

                    override fun onFailure(call: Call<PixRes?>, t: Throwable?) {
                        //callBack.onError(APIErrors())
                        Log.i("huh", "failure")
                    }
                });
            } catch (e: Exception) {
                _status.value = PixApiStatus.ERROR
                //_photos.value = listOf()
            }
        }
    }
}
