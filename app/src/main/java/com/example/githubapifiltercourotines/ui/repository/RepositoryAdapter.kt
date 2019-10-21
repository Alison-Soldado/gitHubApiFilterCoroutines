package com.example.githubapifiltercourotines.ui.repository

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapifiltercourotines.R
import com.example.githubapifiltercourotines.domain.model.RepositoryVO

class RepositoryAdapter(private var repositories: MutableList<RepositoryVO>) :
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

    fun filterForName() {
        repositories.sortBy { it.name.toUpperCase() }
        notifyDataSetChanged()
    }

    fun filterForStar() {
        repositories.sortBy { it.stargazers_count }
        notifyDataSetChanged()
    }

    fun filterForStarCount() {
        repositories
            .asSequence()
            .filter { it.stargazers_count > 100 }
            .map { it.name.plus(" Soldado") }
            .toList()
        notifyDataSetChanged()
    }

    fun filterAddition() {}

    fun filterMultiple() {}
}