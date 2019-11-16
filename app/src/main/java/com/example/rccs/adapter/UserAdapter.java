package com.example.rccs.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.rccs.R;
import com.example.rccs.realm.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    public static final String TAG = "CreditorsAdapter";
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private List<User> userList;
    private Context mContext;
    private OnItemClickListener listener;
    private onEditClickListener editListener;
    private onDeleteClickListener deleteListener;


    public UserAdapter(List<User> userList, Context mContext) {
        this.userList = userList;
        this.mContext = mContext;
        viewBinderHelper.setOpenOnlyOne(true);
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = userList.get(position);

        viewBinderHelper.bind(holder.mSwipeRevealLayout, user.getId());

        holder.mName.setText(user.getUsername());
        holder.mEmail.setText(user.getEmail());

        holder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editListener != null) {
                    editListener.onEditClicked(user.getId());
                }
            }
        });

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deleteListener != null) {
                    deleteListener.onDeleteClicked(user.getId());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mEmail;
        private RelativeLayout mCreditorHolder;
        public SwipeRevealLayout mSwipeRevealLayout;
        public ImageButton mEdit, mDelete;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            mCreditorHolder = itemView.findViewById(R.id.rl_user_holder);
            mName = itemView.findViewById(R.id.tv_username);
            mEmail = itemView.findViewById(R.id.tv_user_email);
            mSwipeRevealLayout = (SwipeRevealLayout) itemView.findViewById(R.id.srl_users);
            mEdit = (ImageButton) itemView.findViewById(R.id.ib_edit);
            mDelete = (ImageButton) itemView.findViewById(R.id.ib_delete);

            mCreditorHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(userList.get(position));
                    }

                }
            });
        }
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public interface OnItemClickListener {
        void onItemClick(User users);
    }

    public void setOnItemClickListener(UserAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public void closeSwipeLayout(String layoutId) {
        viewBinderHelper.closeLayout(layoutId);
    }

    public void saveStates(Bundle outState) {
        viewBinderHelper.saveStates(outState);
    }

    public void restoreStates(Bundle inState) {
        viewBinderHelper.restoreStates(inState);
    }

    public interface onEditClickListener {
        void onEditClicked(String id);
    }

    public void deleteItem(String id) {
//        removeFromDb(id);

        for (User user : userList
        ) {
            if (user.getId().equals(id)) userList.remove(user);
        }
        notifyDataSetChanged();
    }

/*    private void removeFromDb(String id) {
        CreditorRepo.getInstance().deleteCreditorById(id);
        CreditRepo.getInstance().deleteCreditByCreditorId(id);
    }*/

    public interface onDeleteClickListener {
        void onDeleteClicked(String id);
    }

    public void setOnEditClickListener(UserAdapter.onEditClickListener editListener) {
        this.editListener = editListener;
    }

    public void setOnDeleteClickListener(UserAdapter.onDeleteClickListener deleteListener) {
        this.deleteListener = deleteListener;
    }

}
