package com.classjob.cricknews.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.cricknews.Networks.ApiClient;
import com.classjob.cricknews.Networks.ApiService;
import com.classjob.cricknews.Networks.Model.Matches;
import com.classjob.cricknews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Matches> matchesList;
    private ApiService apiService;
    ProgressBar progressBar;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MatchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String param1, String param2) {
        MatchFragment fragment = new MatchFragment();
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
        // return inflater.inflate(R.layout.fragment_match, container, false);
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = view.findViewById(R.id.progress_bar);
        // Initialize data source
        matchesList = new ArrayList<>();

        // Initialize adapter
        adapter = new RecyclerAdapter(getContext(), (ArrayList<Matches>) matchesList);
        recyclerView.setAdapter(adapter);

        // Initialize Retrofit service
        apiService = ApiClient.getClient().create(ApiService.class);

        // Fetch data from the server
        fetchMatchData();
        // adapter.notifyDataSetChanged();
        return view;
    }

    private void fetchMatchData() {

        Call call = apiService.getAllMatches();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful() && response.body() != null) {


                    // Hide the progress bar

                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    List<Matches> newMatchesList = (List<Matches>) response.body();

                    // Clear existing data and add the new data
                    matchesList.clear();
                    matchesList.addAll(newMatchesList);

                    // Notify the adapter of the data change
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Error");

                builder.setMessage("failed to fetchdata" + t.getLocalizedMessage());
                builder.setPositiveButton("Ok", (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
                Toast.makeText(getContext(), "something went wrong failed to fetchdata" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Method to add data to the RecyclerView
    public void addData(Matches matches) {
        matchesList.add(matches);
        adapter.notifyItemInserted(matchesList.size() - 1); // Notify adapter of the new item
    }
}