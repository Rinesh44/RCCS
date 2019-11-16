package com.example.rccs.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rccs.R;
import com.example.rccs.activities.base.BaseActivity;
import com.example.rccs.adapter.UserAdapter;
import com.example.rccs.realm.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserList extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.rv_user_list)
    RecyclerView mUsers;
    @BindView(R.id.tv_no_data)
    TextView mNoData;

    private UserAdapter adapter;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ButterKnife.bind(this);
        initialize();

        User user = new User("asdfsd234", "Rinesh Shakya", "bluescfc44@gmail.com");
        User user1 = new User("asdfsd2df34", "Nikesh Hyanju", "nikeshhyanju@gmail.com");
        userList.add(user);
        userList.add(user1);

        setUpRecyclerView(userList);
    }

    private void initialize() {
        setUpToolbar(mToolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbarTitle.setText("User List");
    }

    private void setUpRecyclerView(List<User> userList) {
        mUsers.setLayoutManager(new LinearLayoutManager(this));
        if (userList == null || userList.isEmpty()) {
            mNoData.setVisibility(View.VISIBLE);
//            mSearch.setVisibility(View.GONE);
            mUsers.setVisibility(View.GONE);
        } else {
            mNoData.setVisibility(View.GONE);
//            mSearch.setVisibility(View.VISIBLE);
            mUsers.setVisibility(View.VISIBLE);

//            creditDtoList = mapModelToDto(creditorsList);
            adapter = new UserAdapter(userList, this);
            adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(User users) {

                }
            });

            mUsers.setAdapter(adapter);
        }


        if (adapter != null) {
            adapter.setOnEditClickListener(new UserAdapter.onEditClickListener() {
                @Override
                public void onEditClicked(String id) {

                }
            });

            adapter.setOnDeleteClickListener(new UserAdapter.onDeleteClickListener() {
                @Override
                public void onDeleteClicked(String id) {

                }
            });
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
