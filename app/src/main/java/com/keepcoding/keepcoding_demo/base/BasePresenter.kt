package com.keepcoding.keepcoding_demo.base

open class BasePresenter<ViewT> : IBasePresenter<ViewT> {

    protected var view: ViewT? = null

    override fun onViewActive(view: ViewT) {
        this.view = view
    }

    override fun onViewInactive() {
        view = null
    }
}