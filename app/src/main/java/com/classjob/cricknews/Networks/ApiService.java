package com.classjob.cricknews.Networks;

import com.classjob.cricknews.Networks.Model.Matches;
import com.classjob.cricknews.Networks.Model.Table;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("matches.php")
    Call<List<Matches>> getAllMatches();

    @GET("stats.php")
    Call<List<Table>> getAllStats();
}
