package com.b07finalproject_group9.owner.ui.notifications;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.b07finalproject_group9.owner.ui.dashboard.ProductAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    private ArrayList<String> notifications;
    private Context context;
    private FragmentManager fragmentManager;
    private OrderModel om = new OrderModel();
    private StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
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


    private void concatString(ArrayList<String> makeNameString, ArrayList<String> makeQuantString,
                              ArrayList<String> makePriceString, HashMap<String, String> hashMap){
        makeNameString.add(hashMap.get("product_name"));
        makePriceString.add(hashMap.get("price"));
        makeQuantString.add(hashMap.get("quantity"));

    }

    private String combineStrings(ArrayList<String> arr){

        String str = new String();
        for(int i = 0; i < arr.size(); i++){
            str = str.concat(arr.get(i)+", ");
        }
        return str;
    }


    ArrayList<String> makeNameString = new ArrayList<>();
    ArrayList<String> makeQuantString = new ArrayList<>();
    ArrayList<String> makePriceString = new ArrayList<>();


    private void processName(String ID){

    }
    private void processID(TextView n, TextView q, TextView p, ArrayList<String> ids){
        for(int i = 0; i < ids.size(); i++){
                String name = new String();
                String price = new String();
                String quantity = new String();

                sm.getSpecificProduct(ids.get(i), MainActivity.currUser.getUsername())
                        .thenAccept(res->{
                            String add_name = res.get("product_name");
                            String add_price = res.get("price");
                            String add_quantity = res.get("quantity");

                            name.concat(add_name+", ");
                            price.concat(add_price+", ");
                            quantity.concat(add_quantity+", ");
                            n.setText(name);
                            p.setText(price);
                            q.setText(quantity);
                        });

            }
        }


                      @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TextView productNames = holder.itemView.findViewById(R.id.productName);
        TextView orderQuantity = holder.itemView.findViewById(R.id.orderQuantity);
        TextView orderPrice = holder.itemView.findViewById(R.id.orderPrice);


        String notification = notifications.get(position);
        holder.notificationText.setText(notification);


        Button completed = holder.itemView.findViewById(R.id.completed);

        om.getProductIDOrderStoreOwner(notification, MainActivity.currUser.getUsername())
                .thenAccept(ids -> processID(productNames, orderQuantity, orderPrice, ids));


        om.getStatusOwner(notification, MainActivity.currUser.getUsername())
                .thenAccept(res->{
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