package com.example.assignment.Repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.assignment.Model.Businesses
import com.example.assignment.Rest.ApiRequest
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class RestaurantPagingSource(val apiService: ApiRequest,val radius:String): PagingSource<Int, Businesses>() {

    override fun getRefreshKey(state: PagingState<Int, Businesses>): Int? {

        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Businesses> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            val abc:String="Bearer XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"

            val response = apiService.getRestaurantDetail(abc, "New York","" + params.loadSize,radius)
            val restaurant = response.businesses

            LoadResult.Page(
                data = restaurant,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (restaurant.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }



}