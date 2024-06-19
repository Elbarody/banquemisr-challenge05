package com.banquemisr.challenge05.utility.network.interceptor

import com.banquemisr.challenge05.utility.network.RemoteConstants.API_TOKEN
import com.banquemisr.challenge05.utility.network.RemoteConstants.HeadersConst.ACCEPT
import com.banquemisr.challenge05.utility.network.RemoteConstants.HeadersConst.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(setupRequestHeaders(chain.request()))
    }

    private fun setupRequestHeaders(request: Request): Request {
        val builder = request.newBuilder()
        builder.addHeader(ACCEPT, "application/json")
        builder.addHeader(
            AUTHORIZATION, API_TOKEN
        )

        return builder.build()
    }
}