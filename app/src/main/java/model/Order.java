package model;

import android.content.Context;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import extra.PrefManager;

/**
 * Created by rutvik on 9/18/2016 at 10:03 AM.
 */

public class Order
{

    final List<MenuItem> menuItemList;

    final String orderNo, orderName, tableNo;

    final long orderTime;

    final String userId, userDisplayName;

    final PrefManager prefManager;

    public Order(final Context context, final String orderNo, final String orderName, final String tableNo, final List<MenuItem> menuItemList)
    {
        prefManager = new PrefManager(context);
        this.orderNo = orderNo;
        this.orderName = orderName;
        this.orderTime = Calendar.getInstance().getTimeInMillis();
        this.tableNo = tableNo;
        this.menuItemList = menuItemList;
        userId = prefManager.getUserId();
        userDisplayName = prefManager.getUserDisplayName();
    }


    public final void addMenuItem(MenuItem menuItem)
    {
        menuItemList.add(menuItem);
    }

    private HashMap<String, Object> toMap()
    {
        final HashMap<String, Object> data = new HashMap<>();

        data.put("user-id", userId);
        data.put("user-display-name", userDisplayName);
        data.put("order-no", orderNo);
        data.put("order-name", orderName);
        data.put("table-no", tableNo);
        data.put("order-time", orderTime);

        return data;
    }


    public static void placeOrder(Order order, PlaceOrderListener placeOrderListener)
    {
        insertOrder(order, placeOrderListener);
    }


    private static void insertOrder(final Order order, final PlaceOrderListener placeOrderListener)
    {
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        dbRef.getRoot();

        final String key = dbRef.child("orders").push().getKey();

        final Map<String, Object> orderData = new HashMap<>();
        orderData.put("/orders/" + key + "/", order.toMap());

        dbRef.updateChildren(orderData, new DatabaseReference.CompletionListener()
        {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference)
            {
                if (databaseError == null)
                {
                    dbRef.getRoot();

                    for (MenuItem item : order.menuItemList)
                    {

                        final String itemKey = dbRef.child("orders").child(key).child("items").push().getKey();
                        final Map<String, Object> itemData = new HashMap<>();

                        itemData.put("/orders/" + key + "/items/" + itemKey + "/", item.toMap());

                        dbRef.updateChildren(itemData);

                    }

                    placeOrderListener.orderPlacedSuccessfully();
                } else
                {
                    placeOrderListener.failedToPlaceOrder(databaseError);
                }
            }
        });
    }


    public List<MenuItem> getMenuItemList()
    {
        return menuItemList;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public String getOrderName()
    {
        return orderName;
    }

    public String getTableNo()
    {
        return tableNo;
    }

    public long getOrderTime()
    {
        return orderTime;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getUserDisplayName()
    {
        return userDisplayName;
    }

    public String getTotalPrice()
    {
        Double totalPrice = 0.0;
        for (MenuItem menuItem : menuItemList)
        {
            final Double price = menuItem.getQuantity() * menuItem.getPrice();
            totalPrice = totalPrice + price;
        }
        return String.valueOf(totalPrice);
    }

    public interface PlaceOrderListener
    {
        void orderPlacedSuccessfully();

        void failedToPlaceOrder(final DatabaseError databaseError);
    }

}
