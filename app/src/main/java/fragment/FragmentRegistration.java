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
public class FragmentRegistration extends Fragment {


    Context context;

    public static FragmentRegistration getInstance(Context context){

        FragmentRegistration f=new FragmentRegistration();
        f.context=context;

        return f;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
