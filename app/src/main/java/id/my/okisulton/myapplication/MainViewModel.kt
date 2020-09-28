package id.my.okisulton.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.okisulton.myapplication.model.Post
import id.my.okisulton.myapplication.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomMapPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomMapPost2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId: Int){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomPost(userId)
            myCustomPost.value = response
        }
    }

    fun getCustomMapPost(UserId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomMapPost(UserId, sort, order)
            myCustomMapPost.value = response
        }
    }

    fun getCustomMapPost2(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomMapPost2(userId, options)
            myCustomMapPost2.value = response
        }
    }
}