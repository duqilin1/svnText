package movie.bw.com.svntext.model;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import movie.bw.com.svntext.contract.MoviesDetailContract;
import movie.bw.com.svntext.model.bean.MoviesDetailBean;
import movie.bw.com.svntext.util.NetUtil;

/*
 *@auther:杜其林
 *@Date: 2020/4/25
 *@Time:16:29
 *@Description:${DESCRIPTION}
 * */
public class MoviesDetailModel implements MoviesDetailContract.IModel {

    @Override
    public void getMoviesDetailData(String userId, String sessionId, String movieId, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApiService().moviesDetailBean(userId, sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoviesDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoviesDetailBean moviesDetailBean) {
                        iModelCallBack.onMoviesDetailSeccess(moviesDetailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onMoviesDetailFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
