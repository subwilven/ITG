package com.islam.task.project_base.base.other.network

import com.islam.task.MyApplication
import com.islam.task.project_base.utils.NetworkManager

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor : Interceptor {

    @Throws(NoConnectivityException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!NetworkManager.isNetworkConnected(MyApplication.instance!!)) {
            throw NoConnectivityException()
        } else {
            chain.proceed(chain.request())
        }
    }


    class NoConnectivityException : IOException()
}
