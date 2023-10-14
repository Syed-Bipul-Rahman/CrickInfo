package com.classjob.cricknews.Networks;

import com.classjob.cricknews.Networks.Model.CricketMatch;
import com.classjob.cricknews.Networks.Model.LiveUrl;
import com.classjob.cricknews.Networks.Model.Matches;
import com.classjob.cricknews.Networks.Model.Table;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET("matches.php")
    Call<List<Matches>> getAllMatches();

    @GET("researchBySyedBipul/json.php")
    Call<LiveUrl> getLiveUrl();

    @GET("stats.php")
    Call<List<Table>> getAllStats();

    @GET()
    Call<CricketMatch> getCricketMatch(@Url String url);


}
