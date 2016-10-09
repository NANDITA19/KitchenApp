package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.fusionbit.kitchenapp.R;

/**
 * Created by Rakshit on 23-09-2016 at 11:38.
 */

public class FragmentTable extends Fragment {
    private Context context;

    public FragmentTable() {

    }

//    public static FragmentTable getInstance(Context context) {
//        FragmentTable fragmentTable = new FragmentTable();
//        fragmentTable.context = context;
//        return fragmentTable;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_table, container, false);
        return parentView;
    }
}
