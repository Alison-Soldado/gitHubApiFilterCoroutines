package com.example.githubapifiltercourotines.ui.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapifiltercourotines.R
import com.example.githubapifiltercourotines.domain.model.RepositoryVO

class RepositoryAdapter(var repositories: MutableList<RepositoryVO>) :
    RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.textViewName.text = repositories[position].name
        holder.textViewDescription.text = repositories[position].description
        holder.textViewStar.text = repositories[position].stargazers_count.toString()
        holder.textViewBranch.text = repositories[position].forks_count.toString()
        holder.textViewUsername.text = repositories[position].full_name
    }

    override fun getItemCount() = repositories.size
}