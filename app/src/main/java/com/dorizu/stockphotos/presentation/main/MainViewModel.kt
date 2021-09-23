package com.dorizu.stockphotos.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dorizu.core.data.ResultState
import com.dorizu.core.domain.model.Photo
import com.dorizu.core.domain.usecase.IPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val photoUseCase: IPhotosUseCase): ViewModel() {

    init {
        getListPhoto()
    }

    private val _listPhoto = MutableLiveData<ResultState<List<Photo>>>()
    val listPhoto: LiveData<ResultState<List<Photo>>> get() = _listPhoto

    fun getListPhoto(){
        val disposable = photoUseCase.getCuratedPhoto()
            .subscribe{res ->
                _listPhoto.value = res
            }
        mCompositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }

    companion object{
        const val TAG = "MainViewModel"
        private val mCompositeDisposable = CompositeDisposable()
    }
}