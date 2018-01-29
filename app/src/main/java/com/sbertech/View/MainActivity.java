package com.sbertech.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.sbertech.Model.AllHubsModelImp;
import com.sbertech.Model.Xml.Rss;
import com.sbertech.Presenter.AllHubsPresenter;
import com.sbertech.Presenter.AllHubsPresenterImp;
import com.sbertech.R;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AllHubsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        presenter = new AllHubsPresenterImp(this, new AllHubsModelImp());
        getData();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void getData() {
        presenter.loadDate();
    }

    @Override
    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setData(Rss result) {

    }
}
