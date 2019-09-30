package com.keepcoding.keepcoding_demo.ui

import com.keepcoding.keepcoding_demo.base.IBasePresenter
import com.keepcoding.keepcoding_demo.base.IBaseView

interface MainContract {
    interface View : IBaseView {

        fun showImages(images: ArrayList<String>)

        fun shouldShowPlaceholderText()
    }

    interface Presenter : IBasePresenter<View> {

        fun getImages()
    }
}