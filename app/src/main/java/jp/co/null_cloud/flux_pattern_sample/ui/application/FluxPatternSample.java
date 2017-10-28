package jp.co.null_cloud.flux_pattern_sample.ui.application;

import android.app.Application;

/**
 * Created by Kai on 2017/10/28.
 */
public class FluxPatternSample extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
