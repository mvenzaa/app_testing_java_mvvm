package com.venza.apptesting.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venza.apptesting.R;
import com.venza.apptesting.model.UserModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserModel> userModels;

    public void setData(List<UserModel> userModels) {
        this.userModels = userModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.textViewUserId.setText(userModels.get(position).getUserId());
        holder.textViewId.setText(userModels.get(position).getId());
        holder.textViewTitle.setText(userModels.get(position).getTitle());
        holder.textViewBody.setText(userModels.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return userModels == null ? 0 : userModels.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUserId;
        TextView textViewId;
        TextView textViewTitle;
        TextView textViewBody;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserId = itemView.findViewById(R.id.txt_user_id);
            textViewId = itemView.findViewById(R.id.txt_id);
            textViewTitle = itemView.findViewById(R.id.txt_title);
            textViewBody = itemView.findViewById(R.id.txt_body);
        }

    }
}
