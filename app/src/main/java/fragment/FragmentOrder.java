package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rakshit on 23-09-2016 at 11:21.
 */

public class FragmentOrder extends Fragment {

    private Context context;

    public FragmentOrder() {

    }

//    public static FragmentOrder getInstance(Context context) {
//        FragmentOrder fragmentOrder = new FragmentOrder();
//        fragmentOrder.context = context;
//
//        return fragmentOrder;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
