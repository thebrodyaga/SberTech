package com.sbertech.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.sbertech.R;
import com.sbertech.component.AllHubsAdapter;
import com.sbertech.model.AllHubsModelImp;
import com.sbertech.model.Xml.Item;
import com.sbertech.model.Xml.Rss;
import com.sbertech.presenter.AllHubsPresenter;
import com.sbertech.presenter.AllHubsPresenterImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BlankFragment extends Fragment implements FragmentView, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AllHubsPresenter presenter;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView.ItemDecoration itemDecoration;
    private LinearLayoutManager layoutManager;
    private AppCompatActivity activity;
    private AllHubsAdapter adapter;
    private List<Item> list;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        layoutManager = new LinearLayoutManager(activity);
        itemDecoration = new DividerItemDecoration(activity,
                layoutManager.getOrientation());
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefresh = view.findViewById(R.id.swipe_container);
        if (savedInstanceState == null) {
            list = new ArrayList<>();
            adapter = new AllHubsAdapter(list);
            presenter = new AllHubsPresenterImp(this, new AllHubsModelImp());
        }
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        swipeRefresh.setOnRefreshListener(this);
        if (savedInstanceState == null)
            getData();
        else hideProgress();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void getData() {
        presenter.loadDate();
    }

    @Override
    public void showProgress() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideProgress() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void showMessage(final String message) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(activity)
                        .setTitle("Ошибка")
                        .setMessage(message)
                        .setPositiveButton("Повторить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                getData();
                            }
                        })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void setData(final Rss result) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.clear();
                Collections.addAll(list, result.getChannel().getItem());
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onRefresh() {
        presenter.refreshData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            presenter.loadDate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
