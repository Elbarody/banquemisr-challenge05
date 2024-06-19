package com.banquemisr.challenge05.utility.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response


class MockInterceptor : Interceptor {

    private val TAG: String = this.javaClass.simpleName

    private val apiMockHelper by lazy {
        mocks {
            // Add mocks here, you can use ApiMock.on method, Regex.replaceWith, String.replaceWith methods to add mocks
            //".*/v2/home-screen" replaceWith "https://run.mocky.io/v3/cef786d9-8048-40b3-9a2e-5e72130f17d3"
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()

        val path = request.url.encodedPath

        apiMockHelper.getMock(path)?.let { mock ->
            Log.d(TAG, "Replaced - ${request.url} - with $mock")
            newRequest.url(mock)
        }

        return chain.proceed(newRequest.build())
    }

}

class ApiMockHelper {
    private val mocks: MutableMap<Regex, String> = mutableMapOf()

    fun on(path: Regex, mockUrl: String) {
        mocks[path] = mockUrl
    }

    fun getMock(path: String): String? =
        mocks.keys.firstOrNull { it.matches(path) }?.let { key -> mocks[key] }

    infix fun Regex.replaceWith(path: String) {
        on(this, path)
    }

    infix fun String.replaceWith(path: String) {
        val regex = Regex(this)
        on(regex, path)
    }

    fun regex(pattern: String) = Regex(pattern)

    fun any() = ".*"
}

fun mocks(block: ApiMockHelper.() -> Unit): ApiMockHelper = ApiMockHelper().apply(block)
