package movie.bw.com.svntext.contract;

import com.stx.xhb.xbanner.XBanner;

import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:20:30
 *@Description:${DESCRIPTION}
 * */
public interface HotContract {
    interface IView{
        void onHotSeccess(HotBean hotBean);
        void onHotFailure(Throwable throwable);

        void onReleaseSeccess(ReleaseBean releaseBean);
        void onReleaseFailure(Throwable throwable);

        void onComingSoonSeccess(ComingSoonBean comingSoonBean);
        void onComingSoonFailure(Throwable throwable);

        void onXBannerSeccess(BannerBean bannerBean);
        void onXBannerFailure(Throwable throwable);
    }

    interface IPresenter{
        void getHtoData(int page,int count);

        void getReleaseData(int page,int count);

        void getComingSoonData(int page,int count);

        void getXBannerData();
    }

    interface IModel{
        void getHtoData(int page,int count,IHotCallBack iHotCallBack);
        void getReleaseData(int page,int count,IReleaseCallBack iReleaseCallBack);
        void getComingSoonData(int page,int count,IComingSoonCallBack iComingSoonCallBack);
        void getXBannerData(IXBannerCallBack ixBannerCallBack);

        interface IHotCallBack{
            void onHotSeccess(HotBean hotBean);
            void onHotFailure(Throwable throwable);
        }

        interface IReleaseCallBack{
            void onReleaseSeccess(ReleaseBean releaseBean);
            void onReleaseFailure(Throwable throwable);
        }

        interface IComingSoonCallBack{
            void onComingSoonSeccess(ComingSoonBean comingSoonBean);
            void onComingSoonFailure(Throwable throwable);
        }
        interface IXBannerCallBack{
            void onXBannerSeccess(BannerBean bannerBean);
            void onXBannerFailure(Throwable throwable);
        }
    }
}
