package movie.bw.com.svntext.presenter;

import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.contract.MoviesDetailContract;
import movie.bw.com.svntext.model.MoviesDetailModel;
import movie.bw.com.svntext.model.bean.MoviesDetailBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/25
 *@Time:16:31
 *@Description:${DESCRIPTION}
 * */
public class MoviesDetailPresenter extends BasePresenter<MoviesDetailContract.IView> implements MoviesDetailContract.IPresenter{

    private MoviesDetailModel moviesDetailModel;

    @Override
    protected void initModel() {
        moviesDetailModel = new MoviesDetailModel();
    }

    @Override
    public void getMoviesDetailData(String userId, String sessionId, String movieId) {
        moviesDetailModel.getMoviesDetailData(userId, sessionId, movieId, new MoviesDetailContract.IModel.IModelCallBack() {
            @Override
            public void onMoviesDetailSeccess(MoviesDetailBean moviesDetailBean) {
                view.onMoviesDetailSeccess(moviesDetailBean);
            }

            @Override
            public void onMoviesDetailFailure(Throwable throwable) {
                view.onMoviesDetailFailure(throwable);
            }
        });
    }
}
