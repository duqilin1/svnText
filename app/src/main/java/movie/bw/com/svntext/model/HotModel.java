package movie.bw.com.svntext.model;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import movie.bw.com.svntext.contract.HotContract;
import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;
import movie.bw.com.svntext.util.NetUtil;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:20:31
 *@Description:${DESCRIPTION}
 * */
public class HotModel implements HotContract.IModel{

    @Override
    public void getHtoData(int page, int count, IHotCallBack iHotCallBack) {
        NetUtil.getInstance().getApiService().hotBean(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        iHotCallBack.onHotSeccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iHotCallBack.onHotFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getReleaseData(int page, int count, IReleaseCallBack iReleaseCallBack) {
        NetUtil.getInstance().getApiService().releaseBean(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReleaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReleaseBean releaseBean) {
                        iReleaseCallBack.onReleaseSeccess(releaseBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iReleaseCallBack.onReleaseFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getComingSoonData(int page, int count, IComingSoonCallBack iComingSoonCallBack) {
        NetUtil.getInstance().getApiService().comingSoonBean(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingSoonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComingSoonBean comingSoonBean) {
                        iComingSoonCallBack.onComingSoonSeccess(comingSoonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iComingSoonCallBack.onComingSoonFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getXBannerData(IXBannerCallBack ixBannerCallBack) {
        NetUtil.getInstance().getApiService().bannerBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        ixBannerCallBack.onXBannerSeccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ixBannerCallBack.onXBannerFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

