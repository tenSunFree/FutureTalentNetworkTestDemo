package com.home.futuretalentnetworktestdemo.list.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.home.futuretalentnetworktestdemo.R
import com.home.futuretalentnetworktestdemo.common.base.BaseActivity
import com.home.futuretalentnetworktestdemo.databinding.ActivityListBinding
import com.home.futuretalentnetworktestdemo.detail.view.activity.DetailActivity
import com.home.futuretalentnetworktestdemo.list.model.viewdata.ListViewData
import com.home.futuretalentnetworktestdemo.list.model.viewstate.ListViewState
import com.home.futuretalentnetworktestdemo.list.model.viewstate.Loading
import com.home.futuretalentnetworktestdemo.list.model.viewstate.NetworkError
import com.home.futuretalentnetworktestdemo.list.model.viewstate.Success
import com.home.futuretalentnetworktestdemo.list.view.adapter.ListAdapter
import com.home.futuretalentnetworktestdemo.list.viewmodel.ListViewModel
import javax.inject.Inject

class ListActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: ListViewModel
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeViewModel()
    }

    private fun initializeView() {
        binding = binding(this, R.layout.activity_list)
    }

    private fun initializeViewModel() {
        homeViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        homeViewModel.requestData()
        homeViewModel.getHomeViewState().observe(this, Observer { setViewState(it) })
    }

    private fun setViewState(viewState: ListViewState) {
        when (viewState) {
            is Loading -> setProgress(true)
            is Success -> {
                setProgress(false)
                showSuccess(viewState.data)
            }
            is NetworkError -> {
                setProgress(false)
                showError(viewState.message)
            }
        }
    }

    private fun setProgress(isLoading: Boolean) {
        if (isLoading) {
            showProgress()
        } else {
            hideProgress()
        }
    }

    private fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progress.visibility = View.GONE
    }

    private fun showSuccess(data: ListViewData) {
        val adapter = ListAdapter()
        adapter.setOnItemClickListener = { login ->
            val bundle = Bundle()
            bundle.putString(getString(R.string.activity_list_key_user_name), login)
            DetailActivity.start(this, bundle)
        }
        adapter.updateList(data.list.toMutableList())
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}