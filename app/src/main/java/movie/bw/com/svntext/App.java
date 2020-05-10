package movie.bw.com.svntext;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/*
 *@auther:杜其林
 *@Date: 2020/4/23
 *@Time:22:00
 *@Description:${DESCRIPTION}
 * */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
