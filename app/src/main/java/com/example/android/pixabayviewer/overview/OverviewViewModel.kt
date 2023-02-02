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

import androidx.lifecycle.*
import com.example.android.pixabayviewer.models.Hit
import com.example.android.pixabayviewer.models.PixRes
import com.example.android.pixabayviewer.network.PixApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


enum class PixApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<PixApiStatus>()
    val status: LiveData<PixApiStatus> = _status

    private val _photos = MutableLiveData<List<Hit>?>()
    val photos: LiveData<List<Hit>?> = _photos

    init {
        currentPage.value=1;
        updateView();

        toSearch.observeForever(Observer{ data->
            updateView();
        })
    }

    public fun loadNextPage(){
        currentPage.value= currentPage.value?.plus(1);
        updateView()
    }

    
    private fun updateView() {
        var map: HashMap<String, String> = HashMap<String, String> ()
        viewModelScope.launch {
            _status.value = PixApiStatus.LOADING
            try {
                map.put("key", "9827246-942760fad484a84884af4a848");

                if(toSearch.value!=null){
                    map.put("q", toSearch.value.toString());
                }
                map.put("image_type","all");
                map.put("page", currentPage.value.toString());

                var lul=PixApi.retrofitService.getImages(map)?.enqueue(object : Callback<PixRes?> {
                    override fun onResponse(call: Call<PixRes?>, response: Response<PixRes?>) {
                        if (response.isSuccessful) {
                            var newData:List<Hit>?= response.body()?.hits
                            if(newData!=null) {
                                if (currentPage.value == 1) {
                                    _photos.value = newData
                                } else {
                                    val joined = ArrayList<Hit>()
                                    _photos.value?.let { joined.addAll(it) }
                                    joined.addAll(newData)
                                    _photos.value = joined
                                }
                            }
                            _status.value = PixApiStatus.DONE
                        } else {
                            _status.value = PixApiStatus.ERROR
                        }
                    }

                    override fun onFailure(call: Call<PixRes?>, t: Throwable?) {
                        _status.value = PixApiStatus.ERROR
                    }
                });
            } catch (e: Exception) {
                _status.value = PixApiStatus.ERROR
            }
        }
    }

    companion object {
        var activeItem= MutableLiveData<Hit>()
        var toSearch = MutableLiveData<String>()
        var currentPage=MutableLiveData<Int>(1)
    }
}
