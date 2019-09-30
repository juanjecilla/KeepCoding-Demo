package com.keepcoding.keepcoding_demo.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class DatabaseManager(context: Context) {

    private val mQueue = Volley.newRequestQueue(context)

    fun getImages(callback: DataSource.GetImagesCallback) {

        val request = JsonArrayRequest(
            Request.Method.GET, API_URL, null,
            Response.Listener { response ->
                val values = ArrayList<String>()
                for (i in 0 until response.length()){
                    values.add(response.getJSONObject(i).getString("download_url"))
                }

                callback.onSuccess(values)
            },
            Response.ErrorListener { error ->
                Log.d(TAG, error.localizedMessage)
                callback.onFailure(error.localizedMessage)
            }
        )

        mQueue.add(request)

    }


    companion object {
        private const val TAG = "DatabaseManager: "
        private const val API_URL = "https://picsum.photos/v2/list"
    }
}
