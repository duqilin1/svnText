package movie.bw.com.svntext.presenter;

import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.contract.HotContract;
import movie.bw.com.svntext.model.HotModel;
import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:20:32
 *@Description:${DESCRIPTION}
 * */
public class HotPresenter extends BasePresenter<HotContract.IView> implements HotContract.IPresenter{

    private HotModel hotModel;

    @Override
    protected void initModel() {
        hotModel = new HotModel();
    }

    @Override
    public void getHtoData(int page, int count) {
        hotModel.getHtoData(page, count, new HotContract.IModel.IHotCallBack() {
            @Override
            public void onHotSeccess(HotBean hotBean) {
                view.onHotSeccess(hotBean);
            }

            @Override
            public void onHotFailure(Throwable throwable) {
                view.onHotFailure(throwable);
            }
        });
    }

    @Override
    public void getReleaseData(int page, int count) {
        hotModel.getReleaseData(page, count, new HotContract.IModel.IReleaseCallBack() {
            @Override
            public void onReleaseSeccess(ReleaseBean releaseBean) {
                view.onReleaseSeccess(releaseBean);
            }

            @Override
            public void onReleaseFailure(Throwable throwable) {
                view.onReleaseFailure(throwable);
            }
        });
    }

    @Override
    public void getComingSoonData(int page, int count) {
        hotModel.getComingSoonData(page, count, new HotContract.IModel.IComingSoonCallBack() {
            @Override
            public void onComingSoonSeccess(ComingSoonBean comingSoonBean) {
                view.onComingSoonSeccess(comingSoonBean);
            }

            @Override
            public void onComingSoonFailure(Throwable throwable) {
                view.onComingSoonFailure(throwable);
            }
        });
    }

    @Override
    public void getXBannerData() {
        hotModel.getXBannerData(new HotContract.IModel.IXBannerCallBack() {
            @Override
            public void onXBannerSeccess(BannerBean bannerBean) {
                view.onXBannerSeccess(bannerBean);
            }

            @Override
            public void onXBannerFailure(Throwable throwable) {
                view.onXBannerFailure(throwable);
            }
        });
    }
}

