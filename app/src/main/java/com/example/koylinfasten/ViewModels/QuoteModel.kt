package com.example.koylinfasten.ViewModels

import androidx.lifecycle.ViewModel
import com.example.koylinfasten.Objects.RetrofitHelper
import com.example.koylinfasten.interfaces.RetrofitEndPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuoteModel : ViewModel() {
    private var index : Int = 0
    private var index2 : Int = 0
    var stg: String = "Michael Jordan"
    var stg2: String = "I've missed more than 9000 shots in my career. I've lost almost 300 games. 26 times, I've been trusted to take the game winning shot and missed. I've failed over and over and over again in my life. And that is why I succeed."
    val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoint::class.java)



    fun authorGet(): String{
        // RetroFit //
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes() // results equals a response<quotelist>
            if (result != null) {
                // Checking the results
                //.body gives the The deserialized response body of a successful response.
                stg = result.body()?.results?.get(index)?.author.toString() + ": "
            }
        }
        index++
        // Retrofit //
        return stg
    }




    fun quoteGet(): String{
        // RetroFit //
        // launching a new coroutine
        GlobalScope.launch {
            val result2 = quotesApi.getQuotes() // results equals a response<quotelist>
            if (result2 != null) {
                // Checking the results
                //.body gives the The deserialized response body of a successful response.
                stg2 = "'"+result2.body()?.results?.get(index2)?.content.toString()+"'"
            }
        }
        index2++
        // Retrofit //
        return stg2
    }


}