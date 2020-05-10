package movie.bw.com.svntext.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseActivity;
import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.view.fragment.Movie2Fragment;

public class MovieActivity extends BaseActivity {

    @BindView(R.id.dian)
    ImageView dian;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.ed_name)
    EditText edName;
    private ArrayList<Fragment> list;
    private ArrayList<String> name;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        name = new ArrayList<>();
        Movie2Fragment movie2Fragment0 = Movie2Fragment.newInstance(0);
        Movie2Fragment movie2Fragment1 = Movie2Fragment.newInstance(1);
        Movie2Fragment movie2Fragment2 = Movie2Fragment.newInstance(2);
        list.add(movie2Fragment0);
        list.add(movie2Fragment1);
        list.add(movie2Fragment2);
        name.add("正在热映");
        name.add("即将上映");
        name.add("热门电影");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_movie;
    }

    @OnClick(R.id.dian)
    public void onViewClicked() {
        edName.setVisibility(View.VISIBLE);
        dian.setVisibility(View.GONE);
    }
}
