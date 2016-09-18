package io.fusionbit.kitchenapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import adapter.OrderAdapter;
import model.MenuItem;
import model.Order;

public class TestActivityViewOrder extends AppCompatActivity
{

    RecyclerView rvOrder;

    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_order);

        rvOrder = (RecyclerView) findViewById(R.id.rv_order);
        rvOrder.setHasFixedSize(true);


        rvOrder.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new OrderAdapter(this);

        rvOrder.setAdapter(adapter);

        insertOrder();

    }

    public void insertOrder()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                final List<MenuItem> menuItemList = new ArrayList<>();
                menuItemList.add(new MenuItem("001", "rice", 2, 80.50));
                menuItemList.add(new MenuItem("002", "dal", 2, 100.68));

                final Order order = new Order(TestActivityViewOrder.this, "001", "raju bhai", "Table 02", menuItemList);
                Order.placeOrder(order, new Order.PlaceOrderListener()
                {
                    @Override
                    public void orderPlacedSuccessfully()
                    {
                        TestActivityViewOrder.this.adapter.addOrder(order);
                        TestActivityViewOrder.this.adapter.notifyDataSetChanged();
                        Toast.makeText(TestActivityViewOrder.this, "order placed successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failedToPlaceOrder(DatabaseError databaseError)
                    {
                        Toast.makeText(TestActivityViewOrder.this, "failed to place order", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }, 5000);
    }

}
