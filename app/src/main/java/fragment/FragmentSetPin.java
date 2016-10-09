package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunil on 9/18/2016.
 */
public class FragmentSetPin extends Fragment {
    Context context;

    public static FragmentSetPin getInstance(Context context){

        FragmentSetPin f=new FragmentSetPin();
        f.context=context;

        return f;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
