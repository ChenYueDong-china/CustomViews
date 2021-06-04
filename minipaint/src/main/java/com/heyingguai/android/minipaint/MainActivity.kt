package com.heyingguai.android.minipaint

import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val myCanvasView by lazy {
        MyCanvasView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
        setContentView(myCanvasView)
    }

    override fun onBackPressed() {
        if (!myCanvasView.pathIsEmpty()) {
            myCanvasView.pathReset()
            return
        }
        super.onBackPressed()
    }
}