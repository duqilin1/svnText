package movie.bw.com.svntext;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:15:07
 *@Description:${DESCRIPTION}
 * */
public interface ApiUrl {
     //接口
    String Url = "http://mobile.bwstudent.com/";
    //登录
    String loginUrl ="movieApi/user/v2/login";
    //注册
    String registerUrl = "movieApi/user/v2/register";
    //热门电影列表
    String HotUrl = "movieApi/movie/v2/findHotMovieList";
    //正在上映电影列表
    String ReleaseUrl = "movieApi/movie/v2/findReleaseMovieList";
    //即将上映电影列表
    String ComingSoonUrl = "movieApi/movie/v2/findComingSoonMovieList";
    //Xbanner列表
    String XBannerUrl = "movieApi/tool/v2/banner";
    //Xbanner列表
    String MoviesDetailUrl = "movieApi/movie/v2/findMoviesDetail";
    //推荐影院
    String RecommendUrl = "movieApi/cinema/v1/findRecommendCinemas";
    //附近影院
    String NearbyUrl = "movieApi/cinema/v1/findNearbyCinemas";
}
