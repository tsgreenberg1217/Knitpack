package com.tgreenberg.knitpack.activities

import KnitPackApi
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.create_page.CreateProjectPage
import com.example.create_page.KnittingProjectViewModel
import com.example.knitpacktheme.theme.KnitPackTheme
import com.tgreenberg.core.models.KnitUri
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateActivity : ComponentActivity() {


    private val knittingProjectViewModel: KnittingProjectViewModel by viewModels()

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        knittingProjectViewModel.setKnitProjectImage(KnitUri(it))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutine = rememberCoroutineScope()
            KnitPackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    CreateProjectPage(
                        knittingProjectViewModel,
                        launchImage = {
                            imageLauncher.launch(it)
                        },
                        submitProject = {
                            coroutine.launch {
//                                knittingProjectViewModel.submitProject()
                            }
                        })
                }

            }
        }
    }


}


//@Preview
//@Composable fun checkitout(){
//    KnitFormUI.KnitPictures()
//}