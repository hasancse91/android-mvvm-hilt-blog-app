package com.hellohasan.mvvmhiltblog.blog_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.mvvmhiltblog.blog_list.model.ModelCallback
import com.hellohasan.mvvmhiltblog.blog_list.model.data.BlogResponse
import com.hellohasan.mvvmhiltblog.blog_list.model.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class BlogListViewModel @Inject constructor(private val repository: BlogRepository) : ViewModel() {

    val showLoaderLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<String>()
    val blogListUiModelLiveData: MutableLiveData<List<BlogItemUiModel>> by lazy {
        MutableLiveData<List<BlogItemUiModel>>()
    }

    fun getBlogList() {
        showLoaderLiveData.postValue(true)

        repository.getBlogList(object : ModelCallback {
            override fun onSuccess(blogResponseList: List<BlogResponse>) {
                val blogListUiModel = getBlogUiModelList(blogResponseList)
                showLoaderLiveData.postValue(false)
                blogListUiModelLiveData.postValue(blogListUiModel)
            }

            override fun onError(error: String) {
                showLoaderLiveData.postValue(false)
                showErrorLiveData.postValue(error)
            }
        })

    }

    private fun getBlogUiModelList(blogResponseList: List<BlogResponse>): List<BlogItemUiModel> {
        val blogUiModelList = mutableListOf<BlogItemUiModel>()

        blogResponseList.forEach {

            val blogUiModel = BlogItemUiModel(
                title = it.title.rendered,
                imageUrl = it.jetpackFeaturedMediaUrl,
                date = getFormatterDate(it.date),
                content = it.content.rendered,
                excerpt = it.excerpt.rendered
            )

            blogUiModelList.add(blogUiModel)
        }

        return blogUiModelList
    }

    private fun getFormatterDate(dateInput: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val blogModifiedDate = inputFormat.parse(dateInput)

        return outputFormat.format(blogModifiedDate)
    }
}