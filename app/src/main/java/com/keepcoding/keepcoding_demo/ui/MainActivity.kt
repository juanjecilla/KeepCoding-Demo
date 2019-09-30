package com.keepcoding.keepcoding_demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.keepcoding.keepcoding_demo.R
import com.keepcoding.keepcoding_demo.base.BaseActivity
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var mAdapter: MainAdapter
    private lateinit var mQueue: RequestQueue

    private lateinit var mPresenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mAdapter = MainAdapter()
        mQueue = Volley.newRequestQueue(this)

        mPresenter = MainPresenter(this)

        image_list.adapter = mAdapter
        image_list.layoutManager = LinearLayoutManager(this)

        getImages()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onViewActive(this)
    }

    override fun onDestroy() {
        mPresenter.onViewInactive()
        super.onDestroy()
    }

    private fun getImages(){
        mPresenter.getImages()
    }

    override fun showImages(images: ArrayList<String>) {
        mAdapter.addAll(images)
    }

    override fun shouldShowPlaceholderText() {

    }
}
