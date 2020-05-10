package movie.bw.com.svntext;

import io.reactivex.Observable;
import movie.bw.com.svntext.model.bean.BannerBean;
import movie.bw.com.svntext.model.bean.ComingSoonBean;
import movie.bw.com.svntext.model.bean.HotBean;
import movie.bw.com.svntext.model.bean.LoginBean;
import movie.bw.com.svntext.model.bean.MoviesDetailBean;
import movie.bw.com.svntext.model.bean.NearbyBean;
import movie.bw.com.svntext.model.bean.RecommendBean;
import movie.bw.com.svntext.model.bean.RegisterBean;
import movie.bw.com.svntext.model.bean.ReleaseBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *@auther:杜其林
 *@Date: 2020/4/17
 *@Time:21:28
 *@Description:${DESCRIPTION}
 * */
public interface ApiService {
    //登录
    @FormUrlEncoded
    @POST(ApiUrl.loginUrl)
    Observable<LoginBean> LOGIN_BEAN_OBSERVABLE(@Field("email") String email,@Field("pwd") String pwd);
    //注册
    @FormUrlEncoded
    @POST(ApiUrl.registerUrl)
    Observable<RegisterBean> REGISTER_BEAN_OBSERVABLE(@Field("nickName") String nickName,
                                                      @Field("email") String email, @Field("pwd") String pwd,
                                                      @Field("code") String code);

    //热门电影列表
    @GET(ApiUrl.HotUrl)
    Observable<HotBean> hotBean(@Query("page") int page, @Query("count") int count);

    //正在上映电影列表
    @GET(ApiUrl.ReleaseUrl)
    Observable<ReleaseBean> releaseBean(@Query("page") int page, @Query("count") int count);

    //即将上映电影列表
    @GET(ApiUrl.ComingSoonUrl)
    Observable<ComingSoonBean> comingSoonBean(@Query("page") int page, @Query("count") int count);
    //Xbanner列表
    @GET(ApiUrl.XBannerUrl)
    Observable<BannerBean> bannerBean();
    //查询电影详情列表
    @GET(ApiUrl.MoviesDetailUrl)
    Observable<MoviesDetailBean> moviesDetailBean(@Header("userId")String userId,
                                                  @Header("sessionId")String sessionId,
                                                  @Query("movieId")String movieId);

    //查询推荐影院信息
    @GET(ApiUrl.RecommendUrl)
    Observable<RecommendBean> recommendBean(@Header("userId")String userId,
                                            @Header("sessionId")String sessionId,
                                            @Query("page")int page,@Query("count")int count);
    //查询推荐影院信息
    @GET(ApiUrl.NearbyUrl)
    Observable<NearbyBean> nearbyBean(@Header("userId")String userId,
                                      @Header("sessionId")String sessionId,
                                      @Query("page")int page, @Query("count")int count);
}
