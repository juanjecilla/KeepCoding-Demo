package com.keepcoding.keepcoding_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: MainAdapter
    private lateinit var mQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mAdapter = MainAdapter()
        mQueue = Volley.newRequestQueue(this)

        image_list.adapter = mAdapter
        image_list.layoutManager = LinearLayoutManager(this)

        getImages()
    }

    private fun getImages(){
        val url = "https://picsum.photos/v2/list"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val values = ArrayList<String>()
                for (i in 0 until response.length()){
                    values.add(response.getJSONObject(i).getString("download_url"))
                }

                mAdapter.addAll(values)
            },
            Response.ErrorListener { error ->
                Log.d(TAG, error.localizedMessage)
            }
        )

        mQueue.add(request)
    }

    companion object {
        private const val TAG = "MainActivity: "
    }
}
