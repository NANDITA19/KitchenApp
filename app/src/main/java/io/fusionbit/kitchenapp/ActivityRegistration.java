package io.fusionbit.kitchenapp;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import adapter.RegistrationViewPagerAdapter;
import fragment.FragmentRegistration;
import fragment.FragmentSetPin;

public class ActivityRegistration extends KitchenAppActivity {


    private NonSwipeableViewPager vpRegistration;

    final RegistrationViewPagerAdapter adapter = new RegistrationViewPagerAdapter(getSupportFragmentManager());

    FragmentRegistration fragmentRegistration;

    FragmentSetPin fragmentSetPin;

    String response="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        vpRegistration = (NonSwipeableViewPager) findViewById(R.id.vp_registration);
        vpRegistration.setOffscreenPageLimit(2);


        fragmentRegistration = FragmentRegistration.getInstance(this);
        adapter.addFragment(fragmentRegistration);


        fragmentSetPin = FragmentSetPin.getInstance(this);
        adapter.addFragment(fragmentSetPin);


        vpRegistration.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        tryLogin();


    }


    private void tryLogin() {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                final Map<String, String> postParam = new HashMap<>();
                postParam.put("first_name", "rutvik");
                postParam.put("last_name", "mehta");
                postParam.put("email", "rutvik@gmail.com");
                postParam.put("password", "rutvik123");
                postParam.put("display_name", "rutvik12343");


                new PostServiceHandler("KITCHEN APP", 3, 2000)
                        .doPutRequest("http://192.168.1.130/codeigniter/index.php/api/User",
                                postParam,
                                new PostServiceHandler.ResponseCallback() {
                                    @Override
                                    public void response(int status, String response) {
                                        if (status == HttpURLConnection.HTTP_OK) {
                                            ActivityRegistration.this.response = response;
                                        }
                                    }
                                });


                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                if (!ActivityRegistration.this.response.isEmpty()) {

                    Toast.makeText(ActivityRegistration.this, response, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ActivityRegistration.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();

    }


}
