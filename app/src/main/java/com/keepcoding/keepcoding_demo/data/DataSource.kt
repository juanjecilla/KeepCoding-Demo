package com.keepcoding.keepcoding_demo.data

import java.util.ArrayList


abstract class DataSource {

    interface GetImagesCallback {
        fun onSuccess(items: ArrayList<String>)

        fun onFailure(error: String)

        fun onCancelled()
    }
}