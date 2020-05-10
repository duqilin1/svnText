package movie.bw.com.svntext.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseFragment;
import movie.bw.com.svntext.contract.HotContract;
import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;
import movie.bw.com.svntext.presenter.HotPresenter;
import movie.bw.com.svntext.util.NetUtil;
import movie.bw.com.svntext.view.activity.MovieActivity;
import movie.bw.com.svntext.view.adapter.ComingSoonAdapter;
import movie.bw.com.svntext.view.adapter.HotAdapter;
import movie.bw.com.svntext.view.adapter.ReleaseAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends BaseFragment<HotPresenter> implements HotContract.IView {

    @BindView(R.id.rv_rmdy)
    RecyclerView rvRmdy;
    @BindView(R.id.rv_zzry)
    RecyclerView rvZzry;
    @BindView(R.id.rv_jjsy)
    RecyclerView rvJjsy;
    @BindView(R.id.rmdy)
    TextView rmdy;
    @BindView(R.id.zzsy)
    TextView zzsy;
    @BindView(R.id.jjsy)
    TextView jjsy;
    @BindView(R.id.banner)
    XBanner banner;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected HotPresenter providePresenter() {
        return new HotPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initData() {
        mPresenter.getHtoData(1, 5);
        mPresenter.getComingSoonData(1, 5);
        mPresenter.getReleaseData(1, 5);
        mPresenter.getXBannerData();
    }

    @Override
    public void onHotSeccess(HotBean hotBean) {
        List<HotBean.ResultBean> result = hotBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvZzry.setLayoutManager(linearLayoutManager);
        HotAdapter hotAdapter = new HotAdapter(result);
        rvZzry.setAdapter(hotAdapter);
    }

    @Override
    public void onHotFailure(Throwable throwable) {
        Toast.makeText(getContext(),"正在热映列表请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReleaseSeccess(ReleaseBean releaseBean) {
        List<ReleaseBean.ResultBean> result = releaseBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvRmdy.setLayoutManager(linearLayoutManager);
        ReleaseAdapter releaseAdapter = new ReleaseAdapter(result);
        rvRmdy.setAdapter(releaseAdapter);
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
        rvJjsy.setLayoutManager(linearLayoutManager);
        ComingSoonAdapter comingSoonAdapter = new ComingSoonAdapter(result);
        rvJjsy.setAdapter(comingSoonAdapter);
    }

    @Override
    public void onComingSoonFailure(Throwable throwable) {
        Toast.makeText(getContext(),"即将上映列表请求失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onXBannerSeccess(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        banner.setBannerData(result);
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                String imageUrl = result.get(position).getImageUrl();
                NetUtil.getInstance().getPhror(imageUrl,(ImageView) view);
            }
        });
    }

    @Override
    public void onXBannerFailure(Throwable throwable) {

    }

    @OnClick({R.id.rmdy, R.id.zzsy, R.id.jjsy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rmdy:
                Intent intent = new Intent(getContext(), MovieActivity.class);
                startActivity(intent);
                break;
            case R.id.zzsy:
                Intent intent1 = new Intent(getContext(), MovieActivity.class);
                startActivity(intent1);
                break;
            case R.id.jjsy:
                Intent intent2 = new Intent(getContext(), MovieActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
