package cf.paradoxie.fragmentfactorydemo.fragment;
/**
 * Created by xiehehe on 2016/10/21.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * User: xiehehe
 * Date: 2016-10-21
 * Time: 21:40
 * FIXME 公共Fragment类，可以在这个类里面进行所有Fragment的共性操作
 */
public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText(getClass().getSimpleName());

        return textView;
    }
}
