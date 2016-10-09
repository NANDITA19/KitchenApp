package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 9/18/2016.
 */
public class RegistrationViewPagerAdapter extends FragmentPagerAdapter {


    final List<Fragment> mFragmentList=new ArrayList<>();


    public RegistrationViewPagerAdapter(FragmentManager manager){
        super(manager);
    }


    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
