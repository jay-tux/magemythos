package org.jaytux.magemytho

import App
import Cache
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(Cache(applicationContext.filesDir.absolutePath + "/", applicationContext.getExternalFilesDir("")!!.absolutePath))
        }
    }
}