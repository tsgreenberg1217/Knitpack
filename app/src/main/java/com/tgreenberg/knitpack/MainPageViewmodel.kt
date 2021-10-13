package com.tgreenberg.knitpack

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor() : ViewModel() {
    var mainRoute: MutableState<MainPageRoute> =  mutableStateOf(MainPageRoute.Patterns)

    fun setPage(route: MainPageRoute){
        mainRoute.value = route
    }
}


