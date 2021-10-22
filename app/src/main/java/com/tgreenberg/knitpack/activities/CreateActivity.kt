package com.tgreenberg.knitpack.activities

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.create_page.CreateProjectPage
import com.example.create_page.KnittingProjectViewModel
import com.example.knitpacktheme.theme.KnitPackTheme
import com.tgreenberg.core.bitmapFromUri
import com.tgreenberg.core.models.KnitUri
import com.tgreenberg.core.resizeByHeight
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CreateActivity : ComponentActivity() {


    private val knittingProjectViewModel: KnittingProjectViewModel by viewModels()

    private val imageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        try {
            it.bitmapFromUri(contentResolver)
                .resizeByHeight(350)
                .run { knittingProjectViewModel.setKnitProjectImage(KnitUri(this)) }
        } catch (e: Exception) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
//                            knittingProjectViewModel.submitProject()
                        })
                }

            }
        }
    }


}
