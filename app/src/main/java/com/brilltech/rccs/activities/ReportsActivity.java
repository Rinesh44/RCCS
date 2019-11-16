package com.brilltech.rccs.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.rccs.R;
import com.brilltech.rccs.activities.base.BaseActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nv)
    NavigationView mNavigationView;

    private ActionBarDrawerToggle actionBarToggle;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        ButterKnife.bind(this);
        init();

        mNavigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            switch (id) {
                case R.id.home:
                    mDrawerLayout.closeDrawers();
//                    startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
                    break;

                case R.id.user_management:
                    startActivity(new Intent(ReportsActivity.this, UserList.class));
//                    syncData();
                    break;

                case R.id.files:
                    startActivity(new Intent(ReportsActivity.this, FilesActivity.class));
                    break;

                case R.id.stats:
                    startActivity(new Intent(ReportsActivity.this, StatsActivity.class));
                    break;

                case R.id.logout:
                    showLogoutDialog();
                    break;

                default:
                    return true;
            }

            mDrawerLayout.closeDrawers();
            return true;

        });

            mNavigationView.setItemIconTintList(null);

    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to logout?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        /*String token = preferences.getString(Constants.TOKEN, "");
                        showLoading();
                        if (token != null) {
                            if (NetworkUtils.isNetworkConnected(DashboardActivity.this)) {
                                presenter.logout(token);
                            } else
                                Toast.makeText(DashboardActivity.this, "Please connect to internet", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(DashboardActivity.this, "Unable to get token", Toast.LENGTH_SHORT).show();*/

                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        final AlertDialog alert11 = builder1.create();
        alert11.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alert11.getButton(AlertDialog.BUTTON_NEGATIVE)
                        .setBackgroundColor(getResources().getColor(R.color.transparent));
                alert11.getButton(AlertDialog.BUTTON_NEGATIVE)
                        .setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                alert11.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.transparent));
                alert11.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(android.R.color.holo_blue_dark));

            }
        });
        alert11.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reports, menu);

        MenuItem searchItem = menu.findItem(R.id.action_serach);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //todo get adapter filter here
                return false;
            }
        });
        return true;
    }


    private void init() {
        setUpToolbar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        mToolbarTitle.setText("Reports");

        actionBarToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(actionBarToggle);
        actionBarToggle.syncState();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarToggle.syncState();
    }


}
