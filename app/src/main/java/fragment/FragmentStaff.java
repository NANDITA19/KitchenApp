package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.fusionbit.kitchenapp.R;

/**
 * Created by Rakshit on 23-09-2016 at 11:46.
 */

public class FragmentStaff extends Fragment {

    public FragmentStaff() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_staff, container, false);

        return parentView;
    }
}
