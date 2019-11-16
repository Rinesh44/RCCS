package com.brilltech.rccs.activities;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.rccs.R;
import com.brilltech.rccs.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportDetails extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.cb_payment)
    CheckBox mPayment;
    @BindView(R.id.cb_event)
    CheckBox mEvent;
    @BindView(R.id.cb_note)
    CheckBox mNote;
    @BindView(R.id.tv_name)
    TextView mName;
    @BindView(R.id.tv_phone)
    TextView mPhone;
    @BindView(R.id.tv_address)
    TextView mAddress;
    @BindView(R.id.tv_pledge_amount)
    TextView mPledgeAmount;
    @BindView(R.id.tv_balance_amount)
    TextView mBalanceAmount;
    @BindView(R.id.tv_pledge_date)
    TextView mPledgeDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);

        ButterKnife.bind(this);

        initialize();
    }

    private void initialize() {
        setUpToolbar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbarTitle.setText("Detail reports");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
