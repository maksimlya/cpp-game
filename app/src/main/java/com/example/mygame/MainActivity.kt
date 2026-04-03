package com.example.mygame

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.androidgamesdk.GameActivity

class MainActivity : GameActivity() {
    companion object {
        init {
            System.loadLibrary("mygame")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This tells the window to draw behind the system bars (Layout Stable/Fullscreen equivalent)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUi()
        }
    }

    private fun hideSystemUi() {
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        
        // Equivalent to SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        controller.systemBarsBehavior = 
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        
        // Equivalent to HIDE_NAVIGATION and FULLSCREEN
        controller.hide(WindowInsetsCompat.Type.systemBars())
    }
}