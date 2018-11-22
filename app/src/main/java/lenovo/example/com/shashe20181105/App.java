package lenovo.example.com.shashe20181105;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author：shashe
 * 日期：2018/11/5
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
        SqliteUtils.getSqliteUtils().init(this);
    }
}
