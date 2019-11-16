package com.brilltech.rccs.activities;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rccs.R;
import com.brilltech.rccs.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.rl_total_balance)
    RelativeLayout mTotalBalance;
    @BindView(R.id.rl_total_donors)
    RelativeLayout mTotalDonors;
    @BindView(R.id.rl_total_payment)
    RelativeLayout mTotalPayment;
    @BindView(R.id.rl_total_pledges)
    RelativeLayout mTotalPledges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        ButterKnife.bind(this);
        initialize();

        mTotalBalance.setOnClickListener(this);
        mTotalDonors.setOnClickListener(this);
        mTotalPayment.setOnClickListener(this);
        mTotalPledges.setOnClickListener(this);
    }

    private void initialize() {
        setUpToolbar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbarTitle.setText("Stats");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_total_balance:
                break;

            case R.id.rl_total_donors:
                break;

            case R.id.rl_total_payment:
                break;

            case R.id.rl_total_pledges:
                break;

            default:
                Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
