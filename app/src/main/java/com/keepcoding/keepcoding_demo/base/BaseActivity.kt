package com.keepcoding.keepcoding_demo.base

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.keepcoding.keepcoding_demo.R

abstract class BaseActivity : AppCompatActivity(), IBaseView {

    private lateinit var progressBar: ProgressBar

    override fun onStart() {
        super.onStart()
        progressBar = findViewById(R.id.progress_bar)
    }

    override fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun setProgressBar(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}