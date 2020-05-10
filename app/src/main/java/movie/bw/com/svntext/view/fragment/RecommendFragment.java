package movie.bw.com.svntext.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseFragment;
import movie.bw.com.svntext.contract.NearbyContract;
import movie.bw.com.svntext.model.bean.NearbyBean;
import movie.bw.com.svntext.model.bean.RecommendBean;
import movie.bw.com.svntext.presenter.NearbyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment<NearbyPresenter> implements NearbyContract.IView {

    @Override
    protected void initView(View inflate) {
        mPresenter.getRecommendData("13775","158502916272813775",1,5);
    }

    @Override
    protected NearbyPresenter providePresenter() {
        return new NearbyPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRecommendSeccess(RecommendBean recommendBean) {

    }

    @Override
    public void onRecommendFailure(Throwable throwable) {

    }

    @Override
    public void onNearbySeccess(NearbyBean nearbyBean) {

    }

    @Override
    public void onNearbyFailure(Throwable throwable) {

    }
}
