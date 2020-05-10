package movie.bw.com.svntext.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseActivity;
import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.view.fragment.MovieFragment;
import movie.bw.com.svntext.view.fragment.MyFragment;
import movie.bw.com.svntext.view.fragment.YingYuanFragment;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.rb_movie)
    RadioButton rbMovie;
    @BindView(R.id.rb_yingyuan)
    RadioButton rbYingyuan;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.rg)
    RadioGroup rg;
    private ArrayList<Fragment> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        MovieFragment movieFragment = new MovieFragment();
        YingYuanFragment yingYuanFragment = new YingYuanFragment();
        MyFragment myFragment = new MyFragment();
        list.add(movieFragment);
        list.add(yingYuanFragment);
        list.add(myFragment);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        return R.layout.activity_home;
    }

    @OnClick({R.id.rb_movie, R.id.rb_yingyuan, R.id.rb_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_movie:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_yingyuan:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_my:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}

