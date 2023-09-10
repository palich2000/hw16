package com.palich.listview

import io.reactivex.Single
import retrofit2.http.GET


interface SuperHeroApiInterface {
    @GET("superhero-api/api/all.json")
    fun getSuperHero(): Single<List<SuperHero>>
}
