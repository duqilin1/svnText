package movie.bw.com.svntext.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseActivity;
import movie.bw.com.svntext.contract.MoviesDetailContract;
import movie.bw.com.svntext.model.bean.MoviesDetailBean;
import movie.bw.com.svntext.presenter.MoviesDetailPresenter;

public class MoviesDetailActivity extends BaseActivity<MoviesDetailPresenter> implements MoviesDetailContract.IView {

    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        String movieId = getIntent().getStringExtra("movieId");
        mPresenter.getMoviesDetailData("13775", "158780269400913775", movieId);
    }

    @Override
    protected MoviesDetailPresenter providePresenter() {
        return new MoviesDetailPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_moviesdetail;
    }

    @Override
    public void onMoviesDetailSeccess(MoviesDetailBean moviesDetailBean) {
        Toast.makeText(MoviesDetailActivity.this, moviesDetailBean.getResult().toString(), Toast.LENGTH_SHORT).show();
        MoviesDetailBean.ResultBean result = moviesDetailBean.getResult();
        Glide.with(img)
                .load(result.getImageUrl())
                .into(img);
    }

    @Override
    public void onMoviesDetailFailure(Throwable throwable) {
        Toast.makeText(MoviesDetailActivity.this, "详情页失败", Toast.LENGTH_SHORT).show();
    }
}
