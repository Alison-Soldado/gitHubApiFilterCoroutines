package com.example.githubapifiltercourotines.ui.repository

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapifiltercourotines.R

class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var textViewName: AppCompatTextView
    var textViewDescription: AppCompatTextView
    var imageViewUser: AppCompatImageView
    var textViewStar: AppCompatTextView
    var textViewBranch: AppCompatTextView
    var textViewUsername: AppCompatTextView

    init {
        this.textViewName = view.findViewById(R.id.item_repository_text_name_item)
        this.textViewDescription = view.findViewById(R.id.item_repository_text_description_item)
        this.imageViewUser = view.findViewById(R.id.item_repository_image_user)
        this.textViewStar = view.findViewById(R.id.item_repository_text_branch_count)
        this.textViewBranch = view.findViewById(R.id.item_repository_text_star_count)
        this.textViewUsername = view.findViewById(R.id.item_repository_text_username)
    }
}