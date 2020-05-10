package movie.bw.com.svntext.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseFragment;
import movie.bw.com.svntext.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }

}
