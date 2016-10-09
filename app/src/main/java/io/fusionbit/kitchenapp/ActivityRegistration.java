package io.fusionbit.kitchenapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.RegistrationViewPagerAdapter;
import fragment.FragmentRegistration;
import fragment.FragmentSetPin;

public class ActivityRegistration extends KitchenAppActivity {



    private NonSwipeableViewPager vpRegistration;

    final RegistrationViewPagerAdapter adapter=new RegistrationViewPagerAdapter(getSupportFragmentManager());

    FragmentRegistration fragmentRegistration;

    FragmentSetPin fragmentSetPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        vpRegistration=(NonSwipeableViewPager) findViewById(R.id.vp_registration);
        vpRegistration.setOffscreenPageLimit(2);


        fragmentRegistration=FragmentRegistration.getInstance(this);

        adapter.addFragment(fragmentRegistration);


        vpRegistration.setAdapter(adapter);



    }
}
