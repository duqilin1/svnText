package movie.bw.com.svntext.contract;

import movie.bw.com.svntext.model.bean.MoviesDetailBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/25
 *@Time:16:26
 *@Description:${DESCRIPTION}
 * */
//电影详情
public interface MoviesDetailContract {
     interface IView{
         void onMoviesDetailSeccess(MoviesDetailBean moviesDetailBean);
         void onMoviesDetailFailure(Throwable throwable);
     }

     interface IPresenter{
         void getMoviesDetailData(String userId,String sessionId,String movieId);
     }

     interface IModel{
         void getMoviesDetailData(String userId,String sessionId,String movieId,IModelCallBack iModelCallBack);

         interface IModelCallBack{
             void onMoviesDetailSeccess(MoviesDetailBean moviesDetailBean);
             void onMoviesDetailFailure(Throwable throwable);
         }
     }
}
