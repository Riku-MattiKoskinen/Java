package com.example.viikko9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView userFirstName, userLastName, userEmail, userDegreeProgram;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.imageView);
        userFirstName = itemView.findViewById(R.id.txtUserFN);
        userLastName = itemView.findViewById(R.id.txtUserLN);
        userEmail = itemView.findViewById(R.id.txtUserEmail);
        userDegreeProgram = itemView.findViewById(R.id.txtUserDP);

    }
}
