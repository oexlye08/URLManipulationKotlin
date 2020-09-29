package id.my.okisulton.myapplication.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("X-Platfrom","Android")
            .addHeader("X-Auth-Token","123456789")
            .build()
        return chain.proceed(request)
    }
}