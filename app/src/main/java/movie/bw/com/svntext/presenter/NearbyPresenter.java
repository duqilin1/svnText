package movie.bw.com.svntext.presenter;

import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.contract.NearbyContract;
import movie.bw.com.svntext.model.NearbyModel;
import movie.bw.com.svntext.model.bean.NearbyBean;
import movie.bw.com.svntext.model.bean.RecommendBean;

/*
 *@auther:杜其林
 *@Date: 2020/5/7
 *@Time:16:55
 *@Description:${DESCRIPTION}
 * */
public class NearbyPresenter extends BasePresenter<NearbyContract.IView> implements NearbyContract.IPresenter{


    private NearbyModel nearbyModel;

    @Override
    protected void initModel() {
        nearbyModel = new NearbyModel();
    }


    @Override
    public void getRecommendData(String userId, String sessionId, int page, int count) {
        nearbyModel.getRecommendData(userId, sessionId, page, count, new NearbyContract.IModel.IRecommendCallBack() {
            @Override
            public void onRecommendSeccess(RecommendBean recommendBean) {
                view.onRecommendSeccess(recommendBean);
            }

            @Override
            public void onRecommendFailure(Throwable throwable) {
                view.onRecommendFailure(throwable);
            }
        });
    }


    @Override
    public void getNearbyData(String userId, String sessionId, int page, int count) {
        nearbyModel.getNearbyData(userId, sessionId, page, count, new NearbyContract.IModel.INearbyCallBack() {
            @Override
            public void onNearbySeccess(NearbyBean nearbyBean) {
                view.onNearbySeccess(nearbyBean);
            }

            @Override
            public void onNearbyFailure(Throwable throwable) {
                view.onNearbyFailure(throwable);
            }
        });
    }
}

