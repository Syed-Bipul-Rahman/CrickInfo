package com.classjob.cricknews.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.classjob.cricknews.Networks.ApiClient2;
import com.classjob.cricknews.Networks.ApiService;
import com.classjob.cricknews.Networks.Model.CricketMatch;
import com.classjob.cricknews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatesFragment extends Fragment {
    String liveUrl;
    private ApiService apiService;
    TextView matchTitle, teamOneScore, teamTwoScore, updateMesssege;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatesFragment newInstance(String param1, String param2) {
        StatesFragment fragment = new StatesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_states, container, false);
        //TODO: code;
        matchTitle = view.findViewById(R.id.titlemathc);
        teamOneScore = view.findViewById(R.id.teamone);
        teamTwoScore = view.findViewById(R.id.teamtwo);
        updateMesssege = view.findViewById(R.id.scoreUpdate);


        // Initialize Retrofit service
        apiService = ApiClient2.getClient().create(ApiService.class);


//        Call<LiveUrl> cal1 = apiService.getLiveUrl();
//        cal1.enqueue(new Callback<LiveUrl>() {
//            @Override
//            public void onResponse(Call<LiveUrl> call, Response<LiveUrl> response) {
//                liveUrl = response.body().getLink();
//                fetchCricketMatchData();
//                Toast.makeText(getContext(), "url found" + response.body().getLink(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<LiveUrl> call, Throwable t) {
//
//
//            }
//        });

        fetchCricketMatchData();


        return view;
    }

    private void fetchCricketMatchData() {


        Call<CricketMatch> call = apiService.getCricketMatch("cri.php?url=https://www.cricbuzz.com/live-cricket-scores/75476/");

        call.enqueue(new Callback<CricketMatch>() {
            @Override
            public void onResponse(Call<CricketMatch> call, Response<CricketMatch> response) {
                if (response.isSuccessful()) {
                    CricketMatch cricketMatch = response.body();
                    Log.d("balcahl", cricketMatch.isSuccess() + "");

                    updateMesssege.setText(cricketMatch.getLiveScore().getUpdate());
                    matchTitle.setText(cricketMatch.getLiveScore().getTitle());
                    teamOneScore.setText(cricketMatch.getLiveScore().getBallsfaced());
                    teamTwoScore.setText(cricketMatch.getLiveScore().getBatsman());

                    // Handle the parsed data here
                } else {

                    // Handle network errors here
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Error");

                    builder.setMessage("failed to fetchdata" + response);
                    builder.setPositiveButton("Ok", (dialog, which) -> {
                        dialog.dismiss();
                    });
                    builder.show();
                    // Toast.makeText(getContext(), "something worng" + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CricketMatch> call, Throwable t) {
                // Handle network errors here
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Error");

                builder.setMessage("failed to fetchdata" + t.getLocalizedMessage());
                builder.setPositiveButton("Ok", (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
                // Toast.makeText(getContext(), "something went wrong failed to fetchdata" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                Toast.makeText(getContext(), "eroro" + t.getLocalizedMessage() + " " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}