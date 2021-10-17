package com.example.mainpage


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.knitpack_components.MainPageRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor() : ViewModel() {
    var mainRoute: MutableState<MainPageRoute> =  mutableStateOf(MainPageRoute.Patterns)

    fun setPage(route: MainPageRoute){
        mainRoute.value = route
    }
}


