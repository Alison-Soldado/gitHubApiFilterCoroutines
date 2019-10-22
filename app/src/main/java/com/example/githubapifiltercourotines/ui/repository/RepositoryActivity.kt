package com.example.githubapifiltercourotines.ui.repository

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapifiltercourotines.R
import com.example.githubapifiltercourotines.delegate.viewProvider
import com.example.githubapifiltercourotines.extension.toast
import com.example.githubapifiltercourotines.extension.visibilityLoading
import com.example.githubapifiltercourotines.util.ItemOffsetDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryActivity : AppCompatActivity() {

    private val viewModel by viewModel<RepositoryViewModel>()
    private lateinit var adapter: RepositoryAdapter
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
        viewModel.loading.observe(this, Observer { loading -> progressBarLoading.visibilityLoading(loading) })

        viewModel.repositories.observe(this, Observer { repositories ->
            adapter = RepositoryAdapter(repositories)
            recyclerViewRepositories.adapter = adapter
        })

        viewModel.error.observe(this, Observer { toast(it.message) })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRepository()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_filter, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_filter_name -> {
                adapter.filterForName()
                true
            }
            R.id.menu_filter_star -> {
                adapter.filterForStar()
                true
            }
            R.id.menu_filter_star_count -> {
                adapter.filterForStarCount()
                true
            }
            R.id.menu_filter_addition -> {
                adapter.filterAddition()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
