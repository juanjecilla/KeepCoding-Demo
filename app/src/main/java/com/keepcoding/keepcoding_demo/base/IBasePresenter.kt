package com.keepcoding.keepcoding_demo.base

interface IBasePresenter<ViewT> {

    fun onViewActive(view: ViewT)

    fun onViewInactive()
}

