package com.hellohasan.mvvmhiltblog.blog_list.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvvmhiltblog.R
import com.hellohasan.mvvmhiltblog.blog_list.view_model.BlogListViewModel
import com.hellohasan.mvvmhiltblog.databinding.ActivityBlogListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogListBinding
    private val viewModel: BlogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getBlogList()

        viewModel.showLoaderLiveData.observe(this) {
            binding.progressBar.isVisible = it ?: false
        }

        viewModel.showErrorLiveData.observe(this) { error ->
            if (error.isNotEmpty()) {
                binding.tvError.text = error
                binding.tvError.isVisible = true
            }
        }

        viewModel.blogListUiModelLiveData.observe(this) { blogList ->
            if (blogList.isNotEmpty()) {
                binding.tvError.isVisible = false
                val layoutManager = LinearLayoutManager(this)
                binding.recyclerView.layoutManager = layoutManager

                val adapter = BlogPostRecyclerViewAdapter(blogList)
                binding.recyclerView.adapter = adapter

                binding.progressBar.isVisible = false
            } else {
                binding.tvError.text = getString(R.string.empty_list_message)
                binding.tvError.isVisible = true
            }
        }
    }
}