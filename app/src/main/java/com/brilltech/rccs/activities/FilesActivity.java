package com.brilltech.rccs.activities;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brilltech.rccs.R;
import com.brilltech.rccs.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilesActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.rl_donors)
    RelativeLayout mDonors;
    @BindView(R.id.rl_pledges)
    RelativeLayout mPledges;
    @BindView(R.id.rl_payment)
    RelativeLayout mPayment;
    @BindView(R.id.rl_balance)
    RelativeLayout mBalance;
    @BindView(R.id.rl_phone)
    RelativeLayout mPhone;
    @BindView(R.id.rl_association)
    RelativeLayout mAssociation;
    @BindView(R.id.rl_address)
    RelativeLayout mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        ButterKnife.bind(this);

        initialize();

        mDonors.setOnClickListener(this);
        mPledges.setOnClickListener(this);
        mPayment.setOnClickListener(this);
        mBalance.setOnClickListener(this);
        mPhone.setOnClickListener(this);
        mAssociation.setOnClickListener(this);
        mAddress.setOnClickListener(this);
    }

    private void initialize() {
        setUpToolbar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbarTitle.setText("Files");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_address:
                break;

            case R.id.rl_association:
                break;

            case R.id.rl_balance:
                break;

            case R.id.rl_donors:
                break;

            case R.id.rl_payment:
                break;

            case R.id.rl_phone:
                break;

            case R.id.rl_pledges:
                break;

            default:
                Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
