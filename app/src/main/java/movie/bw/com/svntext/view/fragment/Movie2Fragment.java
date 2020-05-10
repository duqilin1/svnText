package movie.bw.com.svntext.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseFragment;
import movie.bw.com.svntext.contract.HotContract;
import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;
import movie.bw.com.svntext.presenter.HotPresenter;
import movie.bw.com.svntext.view.adapter.ComingSoon2Adapter;
import movie.bw.com.svntext.view.adapter.ComingSoonAdapter;
import movie.bw.com.svntext.view.adapter.Hot2Adapter;
import movie.bw.com.svntext.view.adapter.HotAdapter;
import movie.bw.com.svntext.view.adapter.Release2Adapter;
import movie.bw.com.svntext.view.adapter.ReleaseAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Movie2Fragment extends BaseFragment<HotPresenter> implements HotContract.IView {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected HotPresenter providePresenter() {
        return new HotPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_movie2;
    }

    @Override
    protected void initData() {
        int key = getArguments().getInt("key");
        if (key == 0) {
            mPresenter.getHtoData(1, 5);
        } else if (key == 1) {
            mPresenter.getComingSoonData(1, 5);
        } else if (key == 2) {
            mPresenter.getReleaseData(1, 5);
        }
    }

    @Override
    public void onHotSeccess(HotBean hotBean) {
        List<HotBean.ResultBean> result = hotBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        Hot2Adapter hot2Adapter = new Hot2Adapter(result);
        rv.setAdapter(hot2Adapter);
    }

    @Override
    public void onHotFailure(Throwable throwable) {
        Toast.makeText(getContext(),"正在热映列表请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReleaseSeccess(ReleaseBean releaseBean) {
        List<ReleaseBean.ResultBean> result = releaseBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        Release2Adapter release2Adapter = new Release2Adapter(result);
        rv.setAdapter(release2Adapter);
    }

    @Override
    public void onReleaseFailure(Throwable throwable) {
        Toast.makeText(getContext(),"热门电影列表请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComingSoonSeccess(ComingSoonBean comingSoonBean) {
        List<ComingSoonBean.ResultBean> result = comingSoonBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        ComingSoon2Adapter comingSoon2Adapter = new ComingSoon2Adapter(result);
        rv.setAdapter(comingSoon2Adapter);
    }

    @Override
    public void onComingSoonFailure(Throwable throwable) {
        Toast.makeText(getContext(),"即将上映列表请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onXBannerSeccess(BannerBean bannerBean) {

    }

    @Override
    public void onXBannerFailure(Throwable throwable) {

    }

    public static Movie2Fragment newInstance(int values) {
        Bundle args = new Bundle();
        Movie2Fragment fragment = new Movie2Fragment();
        args.putInt("key", values);
        fragment.setArguments(args);
        return fragment;
    }
}
