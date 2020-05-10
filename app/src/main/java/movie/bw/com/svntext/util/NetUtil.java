package movie.bw.com.svntext.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.TimeUnit;

import movie.bw.com.svntext.ApiService;
import movie.bw.com.svntext.ApiUrl;
import movie.bw.com.svntext.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:杜其林
 *@Date: 2020/4/17
 *@Time:21:27
 *@Description:${DESCRIPTION}
 * */
public class NetUtil {

    private final ApiService apiService;

    public NetUtil() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiUrl.Url)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }
    public static final class SingleHolder{
        public static final NetUtil NET_UTIL = new NetUtil();
    }

    public ApiService getApiService() {
        return apiService;
    }

    //请求图片
    public void getPhror(String phrorUrl, ImageView imageView) {
        Glide.with(imageView).load(phrorUrl)
                //设置站位图
                .placeholder(R.mipmap.ic_launcher)
                //设置失败图
                .error(R.mipmap.ic_launcher_round)
                //圆角
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                //设置图片
                .into(imageView);
    }
}

