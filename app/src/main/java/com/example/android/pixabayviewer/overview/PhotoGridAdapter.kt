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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.pixabayviewer.databinding.GridViewItemBinding
import com.example.android.pixabayviewer.models.Hit

class PhotoGridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Hit, PhotoGridAdapter.PixabayViewerViewHolder>(DiffCallback) {

    class PixabayViewerViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Hit) {
            binding.photo = photo
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.previewURL == newItem.previewURL
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PixabayViewerViewHolder {
        return PixabayViewerViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: PixabayViewerViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsPhoto)
        }
        holder.bind(marsPhoto)
    }


    class OnClickListener(val clickListener: (meme: Hit) -> Unit) {
        fun onClick(meme: Hit) = clickListener(meme)
    }
}
