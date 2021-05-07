package com.example.llyods_project.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import com.example.llyods_project.R;
import com.example.llyods_project.adapter.RecyclerViewAdapter;
import com.example.llyods_project.model.HitsItem;
import com.example.llyods_project.model.Pixabay_Res;
import com.example.llyods_project.rf_network.API_Interface;
import com.example.llyods_project.rf_network.API_Service;
import com.example.llyods_project.viewmodels.PicViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActivity context;
    PicViewModel viewModel;
    RecyclerView recyclerView;
    EditText ed_Searchtext;
    private API_Interface service;
    private RecyclerViewAdapter recyclerViewAdapter;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    private StaggeredGridLayoutManager mLayoutManager;
    private String search="flowers";
    int n_page= 1;
    List<HitsItem> img_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.rv_photos);
        ed_Searchtext = findViewById(R.id.ed_searchtext);
        viewModel = ViewModelProviders.of(context).get(PicViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);
        service = API_Service.getClient(this).create(API_Interface.class);
        recyclerViewAdapter = new RecyclerViewAdapter(context, img_list);
        mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        viewModel.callapi(search,service,MainActivity.this, n_page);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) { //check for scroll down
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
//                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
                    int[] firstVisibleItems = null;
                    firstVisibleItems = mLayoutManager.findFirstVisibleItemPositions(firstVisibleItems);
                    if(firstVisibleItems != null && firstVisibleItems.length > 0) {
                        pastVisiblesItems = firstVisibleItems[0];
                    }
                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            Log.e("onscrolled-itemcount", "scrolledcount"+totalItemCount );
                            loading = false;
//                            n_page = (totalItemCount/9)+1;

                            viewModel.callapi(search,service,MainActivity.this,n_page);
                        }
                    }
                }
            }
        });

        ed_Searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search = s+"";
               // if(search.length()==0){
                    n_page = 1;
                    img_list.clear();
                    recyclerViewAdapter.notifyDataSetChanged();
               // }
                viewModel.callapi(search,service,MainActivity.this, n_page);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    Observer<Pixabay_Res> userListUpdateObserver = new Observer<Pixabay_Res>() {
        @Override
        public void onChanged(Pixabay_Res userArrayList) {
//               list = userArrayList.getHits();
            if(userArrayList.getHits().size()!=0) {

                Log.e("onscrolled-itemcount", "listsize"+userArrayList.getHits().size()+"page"+n_page );
                loading = true;

                img_list.addAll(userArrayList.getHits());
//                recyclerViewAdapter = new RecyclerViewAdapter(context, img_list);
//                mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(mLayoutManager);
//                if (n_page > 1) {
                    recyclerViewAdapter.notifyDataSetChanged();
//                } else {
//                    recyclerView.setAdapter(recyclerViewAdapter);
//                }
                n_page = n_page+1;
            }
        }
    };
}