package io.fusionbit.kitchenapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import model.MenuItem;
import model.Order;

public class ActivityInitial extends KitchenAppActivity
{

    private static final String TAG = AppUtils.APP_TAG + ActivityInitial.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(ActivityInitial.this,TestActivityViewOrder.class));
            }
        },2000);

    }


}
