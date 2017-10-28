package jp.co.null_cloud.flux_pattern_sample.ui.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.co.null_cloud.flux_pattern_sample.flux.Dispatcher;
import jp.co.null_cloud.flux_pattern_sample.ui.views.adapter.TodoAdapter;

/**
 * Created by Kai on 2017/10/28.
 */
@Singleton
@Module
public class AppModule {

    @Provides
    @Singleton
    public Dispatcher provideDispatcher() {
        return Dispatcher.getInstance();
    }

    @Provides
    @Singleton
    public TodoAdapter provideAdapter() {
        return new TodoAdapter();
    }

}
