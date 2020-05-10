package movie.bw.com.svntext.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseFragment;
import movie.bw.com.svntext.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class YingYuanFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;
    private ArrayList<String> name;

    @Override
    protected void initView(View inflate) {
        list = new ArrayList<>();
        name = new ArrayList<>();
        RecommendFragment recommendFragment = new RecommendFragment();
        NearbyFragment nearbyFragment = new NearbyFragment();
        DiQuFragment diQuFragment = new DiQuFragment();
        list.add(recommendFragment);
        list.add(nearbyFragment);
        list.add(diQuFragment);
        name.add("推荐影院");
        name.add("附近影院");
        name.add("海淀区");
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return name.get(position);
            }
        });
        tab.setupWithViewPager(vp);
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_yingyuan;
    }

    @Override
    protected void initData() {

    }
}
