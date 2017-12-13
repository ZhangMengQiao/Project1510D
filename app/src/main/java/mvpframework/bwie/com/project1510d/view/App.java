package mvpframework.bwie.com.project1510d.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/12/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //ImageLoader对象
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
        Fresco.initialize(this);

    }
}
