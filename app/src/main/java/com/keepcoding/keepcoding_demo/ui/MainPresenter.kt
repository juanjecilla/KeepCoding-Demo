package com.keepcoding.keepcoding_demo.ui

import android.content.Context
import android.util.Log
import com.keepcoding.keepcoding_demo.base.BasePresenter
import com.keepcoding.keepcoding_demo.data.DataSource
import com.keepcoding.keepcoding_demo.data.DatabaseManager
import java.util.ArrayList

class MainPresenter(private val mContext: Context) :
    BasePresenter<MainContract.View>(), MainContract.Presenter {

    private val mDatabaseManager: DatabaseManager = DatabaseManager(mContext)

    override fun getImages() {
        view?.setProgressBar(true)

        mDatabaseManager.getImages(object : DataSource.GetImagesCallback {
            override fun onSuccess(items: ArrayList<String>) {
                view?.setProgressBar(false)
                view?.showImages(items)
                view?.shouldShowPlaceholderText()
            }

            override fun onFailure(error: String) {
                view?.setProgressBar(false)
                view?.shouldShowPlaceholderText()
                view?.showToastMessage(error)
                Log.d(TAG, error)
            }

            override fun onCancelled() {
                view?.setProgressBar(false)
                view?.shouldShowPlaceholderText()
                Log.d(TAG, "On cancelled")
            }
        })
    }

    companion object {
        private const val TAG = "MainPresenter: "
    }
}


