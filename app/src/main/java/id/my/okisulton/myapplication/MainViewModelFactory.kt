package id.my.okisulton.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.my.okisulton.myapplication.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository)as T
    }
}