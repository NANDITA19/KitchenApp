package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.fusionbit.kitchenapp.R;

/**
 * Created by Rakshit on 23-09-2016 at 11:45.
 */

public class FragmentMenu extends Fragment {

    public FragmentMenu() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_menu, container, false);

        return parentView;
    }
}
