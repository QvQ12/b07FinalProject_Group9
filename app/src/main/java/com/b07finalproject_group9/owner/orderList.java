//package com.b07finalproject_group9.owner;
//
//import com.b07finalproject_group9.DatabaseModel;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//import java.util.List;

package com.b07finalproject_group9.owner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orderList {
    String orderId;
    String shopperId;
    String userStatus;
    List<String> storeId;
    List<String> productList;
    List<String> deliveryStatus;

    public orderList(String orderId, String shopperId, String userStatus,
                     List<String> storeId, List<String> productList,
                     List<String> deliveryStatus) {
        this.orderId = orderId;
        this.shopperId= shopperId;
        this.userStatus = userStatus;
        this.storeId = storeId;
        this.productList = productList;
        this.deliveryStatus = deliveryStatus;
    }

    public Map<String,Object> createMap(){
        HashMap<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("orderId", orderId);
        orderInfo.put("storeList", storeId);
        orderInfo.put("shopperId", shopperId);
        orderInfo.put("productList", productList);
        orderInfo.put("userStatus", userStatus);
        orderInfo.put("deliveryList", deliveryStatus);
        return orderInfo;
    }


}

//public class orderList extends DatabaseModel{
//    private String ACTIVITY_KEY = "https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com/";
//    FirebaseDatabase fdb = FirebaseDatabase.getInstance(ACTIVITY_KEY);
//    DatabaseReference db = fdb.getReference();
//
//    public void addOrder(String shopper, String userStatus, List<String> storeList,List<String>productList, List<String> deliveryList){
//        String orderId;
//        DatabaseReference shopperRef = db.child("Global-Order-List");
//        orderId = FirebaseDatabase.getInstance().getReference().child("Global-Order-List").push().getKey();
//        HashMap<String, Object> orderInfo = new HashMap<>();
//        orderInfo.put("orderId", orderId);
//        orderInfo.put("storeList", storeList);
//        orderInfo.put("shopperId", shopper);
//        orderInfo.put("productList", productList);
//        orderInfo.put("userStatus", userStatus);
//        orderInfo.put("deliveryList", deliveryList);
//        shopperRef.child(orderId).setValue(orderInfo);
//    }
//}
//}

//public class orderList extends DatabaseModel{
//    private String ACTIVITY_KEY = "https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com/";
//    FirebaseDatabase fdb = FirebaseDatabase.getInstance(ACTIVITY_KEY);
//    DatabaseReference db = fdb.getReference();
//
//    public void addOrder(String shopper, String userStatus, List<String> storeList,List<String>productList, List<String> deliveryList){
//        String orderId;
//        DatabaseReference shopperRef = db.child("Global-Order-List");
//        orderId = FirebaseDatabase.getInstance().getReference().child("Global-Order-List").push().getKey();
//        HashMap<String, Object> orderInfo = new HashMap<>();
//        orderInfo.put("orderId", orderId);
//        orderInfo.put("storeList", storeList);
//        orderInfo.put("shopperId", shopper);
//        orderInfo.put("productList", productList);
//        orderInfo.put("userStatus", userStatus);
//        orderInfo.put("deliveryList", deliveryList);
//        shopperRef.child(orderId).setValue(orderInfo);
//    }
//}


//public void addOrder(String shopper, String userStatus, List<String> storeList, List<String>productList, List<String> deliveryList){
//        DatabaseReference db = fdb.getReference();
//        String orderId;
//        DatabaseReference shopperRef = db.child("Global-Order-List");
//        orderId = FirebaseDatabase.getInstance().getReference().child("Global-Order-List").push().getKey();
//        HashMap<String, Object> orderInfo = new HashMap<>();
//        orderInfo.put("orderId", orderId);
//        orderInfo.put("storeList", storeList);
//        orderInfo.put("shopperId", shopper);
//        orderInfo.put("productList", productList);
//        orderInfo.put("userStatus", userStatus);
//        orderInfo.put("deliveryList", deliveryList);
//        shopperRef.child(orderId).setValue(orderInfo);
//        }
