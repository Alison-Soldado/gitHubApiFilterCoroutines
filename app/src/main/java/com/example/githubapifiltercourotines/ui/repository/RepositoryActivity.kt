package com.example.githubapifiltercourotines.ui.repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapifiltercourotines.R
import com.example.githubapifiltercourotines.delegate.viewProvider
import com.example.githubapifiltercourotines.util.ItemOffsetDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryActivity : AppCompatActivity() {

    private val viewModel by viewModel<RepositoryViewModel>()
    private val recyclerViewRepositories: RecyclerView by viewProvider(R.id.activity_repository_recycler_repositories)
    private val progressBarLoading: ProgressBar by viewProvider(R.id.activity_repository_progress)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        setupView()
        initObserver()
    }

    private fun setupView() {
        with(recyclerViewRepositories) {
            addItemDecoration(ItemOffsetDecoration(this@RepositoryActivity, R.dimen.smal_margin))
            layoutManager = LinearLayoutManager(this@RepositoryActivity)
            setHasFixedSize(true)
        }
    }

    private fun initObserver() {
        viewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                progressBarLoading.visibility = View.VISIBLE
            } else {
                progressBarLoading.visibility = View.GONE
            }
        })

        viewModel.repositories.observe(this, Observer { repositories ->
            recyclerViewRepositories.adapter = RepositoryAdapter(repositories)
        })

        viewModel.error.observe(this, Observer {
            Log.d("error", "Message: ${it.message}")
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRepository()
    }
}
