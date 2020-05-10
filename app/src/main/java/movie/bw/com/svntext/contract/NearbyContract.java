package movie.bw.com.svntext.contract;

import movie.bw.com.svntext.model.bean.NearbyBean;
import movie.bw.com.svntext.model.bean.RecommendBean;

/*
 *@auther:杜其林
 *@Date: 2020/5/7
 *@Time:16:49
 *@Description:${DESCRIPTION}
 * */
public interface NearbyContract {
    interface IView{
        void onRecommendSeccess(RecommendBean recommendBean);
        void onRecommendFailure(Throwable throwable);

        void onNearbySeccess(NearbyBean nearbyBean);
        void onNearbyFailure(Throwable throwable);
    }

    interface IPresenter{
        void getRecommendData(String userId,String sessionId,int page,int count);

        void getNearbyData(String userId,String sessionId,int page,int count);
    }

    interface IModel{
        void getRecommendData(String userId,String sessionId,int page,int count,IRecommendCallBack iRecommendCallBack);
        void getNearbyData(String userId,String sessionId,int page,int count,INearbyCallBack iNearbyCallBack);

        interface IRecommendCallBack{
            void onRecommendSeccess(RecommendBean recommendBean);
            void onRecommendFailure(Throwable throwable);
        }

        interface INearbyCallBack{
            void onNearbySeccess(NearbyBean nearbyBean);
            void onNearbyFailure(Throwable throwable);
        }
    }
}
