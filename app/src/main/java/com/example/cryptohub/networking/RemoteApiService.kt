package com.example.cryptohub.networking

import com.example.cryptohub.model.GetChartDataResponse
import com.example.cryptohub.model.GetCoinsResponse
import com.example.cryptohub.model.GetExchangeResponse
import com.example.cryptohub.model.GetNewsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Holds the API calls for the Taskie app.
 */
interface RemoteApiService {

    // get top news
    @GET("v2/news/")
    fun getTopNews(
        @Query("lang") lang: String = "EN", @Query("sortOrder") sortOrder: String = "popular"
    ): Call<GetNewsResponse>


    // get top coins
    @GET("top/totalvolfull")
    fun getTopCoins(
        @Query("tsym") to_symbol: String = "USD",
        @Query("limit") limit_data: Int = 20
    ): Call<GetCoinsResponse>


    // get exchange rates
    @GET("price")
    fun getRates(
        @Query("fsym") fromSymbol: String = "USD", @Query("tsyms") toSymbol: String
    ): Call<GetExchangeResponse>


    // get chart data
    @GET("v2/{period}")
    fun getChartData(
        @Path("period") period : String,
        @Query("fsym") fromSymbol: String,
        @Query("limit") limit: Int,
        @Query("aggregate") aggregate: Int,
        @Query("tsym") toSymbol: String = "USD"
    ): Call<GetChartDataResponse>

}