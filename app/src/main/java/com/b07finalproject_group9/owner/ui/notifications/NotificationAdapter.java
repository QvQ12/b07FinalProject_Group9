package com.b07finalproject_group9.owner.ui.notifications;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.owner.ui.dashboard.ProductAdapter;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    private ArrayList<String> notifications;
    private Context context;
    private FragmentManager fragmentManager;
    private OrderModel om = new OrderModel();
    private boolean isClicked = false;



    public NotificationAdapter(Context context, ArrayList<String> notifications,FragmentManager fragmentManager) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notification_display, parent, false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String notification = notifications.get(position);
        holder.notificationText.setText(notification);

        Button completed = holder.itemView.findViewById(R.id.completed);

        om.getStatusOwner(notification, MainActivity.currUser.getUsername())
                .thenAccept(res->{
                    Log.i("COMPLETED", res.toString());
                    if(res){
                        isClicked = true;
                        completed.setText("Completed!");
                        completed.setBackgroundTintList(context
                                .getResources().getColorStateList(R.color.clickedButtonColor));
                    } else{
                        isClicked = false;
                        completed.setText("Not Completed!");
                        completed.setBackgroundTintList(context
                                .getResources().getColorStateList(R.color.defaultButtonColor));
                    }
                });
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClicked){
                    completed.setText("Completed!");
                    completed.setBackgroundTintList(context
                            .getResources().getColorStateList(R.color.clickedButtonColor));
                    isClicked = false;
                    om.setStatusOwner(notification, MainActivity.currUser.getUsername(), "1");
                } else{
                    completed.setText("Not Completed!");
                    completed.setBackgroundTintList(context
                            .getResources().getColorStateList(R.color.defaultButtonColor));
                    om.setStatusOwner(notification, MainActivity.currUser.getUsername(), "0");
                    isClicked = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView notificationText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationText = itemView.findViewById(R.id.notificationId);
        }
    }
}