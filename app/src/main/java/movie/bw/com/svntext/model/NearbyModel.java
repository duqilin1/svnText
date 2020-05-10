package movie.bw.com.svntext.model;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import movie.bw.com.svntext.contract.NearbyContract;
import movie.bw.com.svntext.model.bean.NearbyBean;
import movie.bw.com.svntext.model.bean.RecommendBean;
import movie.bw.com.svntext.util.NetUtil;

/*
 *@auther:杜其林
 *@Date: 2020/5/7
 *@Time:16:52
 *@Description:${DESCRIPTION}
 * */
public class NearbyModel implements NearbyContract.IModel{

    @Override
    public void getRecommendData(String userId, String sessionId, int page, int count, IRecommendCallBack iRecommendCallBack) {
        NetUtil.getInstance().getApiService().recommendBean(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        iRecommendCallBack.onRecommendSeccess(recommendBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iRecommendCallBack.onRecommendFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void getNearbyData(String userId, String sessionId, int page, int count, INearbyCallBack iNearbyCallBack) {
        NetUtil.getInstance().getApiService().nearbyBean(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearbyBean nearbyBean) {
                        iNearbyCallBack.onNearbySeccess(nearbyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iNearbyCallBack.onNearbyFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

