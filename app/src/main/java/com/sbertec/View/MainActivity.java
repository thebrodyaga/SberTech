package com.sbertec.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.sbertec.Model.AllHubsModelImp;
import com.sbertec.Model.Xml.Rss;
import com.sbertec.Presenter.AllHubsPresenter;
import com.sbertec.Presenter.AllHubsPresenterImp;
import com.sbertec.R;

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
        recyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setData(Rss result) {

    }
}
