package com.classjob.cricknews.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.cricknews.Networks.ApiClient;
import com.classjob.cricknews.Networks.ApiService;
import com.classjob.cricknews.Networks.Model.Table;
import com.classjob.cricknews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment {
    private RecyclerView recyclerView;
    private TableAdapter adapter;
    private List<Table> tableList;
    private ApiService apiService;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_table, container, false);


        View view = inflater.inflate(R.layout.fragment_table, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.tableRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data source
        tableList = new ArrayList<>();

        // Initialize adapter
        adapter = new TableAdapter(getContext(), (ArrayList<Table>) tableList);
        recyclerView.setAdapter(adapter);


        // Initialize Retrofit service
        apiService = ApiClient.getClient().create(ApiService.class);


        fetchStatsData();

        return view;

    }

    private void fetchStatsData() {

        Call call = apiService.getAllStats();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    // Log.d("response", "onResponse: "+response.body());
                    List<Table> table = (List<Table>) response.body();
                    for (int i = 0; i < table.size(); i++) {
                        addData(table.get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong, failed to fetch data from server", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void addData(Table table) {
        tableList.add(table);
        adapter.notifyItemInserted(tableList.size() - 1); // Notify adapter of the new item
    }
}