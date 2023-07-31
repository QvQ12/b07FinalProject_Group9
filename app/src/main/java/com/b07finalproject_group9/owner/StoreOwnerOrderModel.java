package com.b07finalproject_group9.owner;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class StoreOwnerOrderModel extends DatabaseModel {

    private void createNewOrder(String orderId, String shopperId, String userStatus,
                                List<String> storeId, List<String> productList,
                                List<String> deliveryStatus) {

        orderList order = new orderList(orderId, shopperId,  userStatus,
                                         storeId,  productList,
                                        deliveryStatus) ;
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child("Global-Order-List").setValue(order.createMap());
    }


}
