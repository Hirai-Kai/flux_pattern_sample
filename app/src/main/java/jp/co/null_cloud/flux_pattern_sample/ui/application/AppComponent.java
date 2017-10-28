package jp.co.null_cloud.flux_pattern_sample.ui.application;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.null_cloud.flux_pattern_sample.ui.component.MainActionCreator;
import jp.co.null_cloud.flux_pattern_sample.ui.component.MainStore;
import jp.co.null_cloud.flux_pattern_sample.ui.views.adapter.TodoAdapter;

/**
 * Created by Kai on 2017/10/28.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    MainActionCreator mainActionCreator();

    MainStore mainStore();

    TodoAdapter todoAdapter();

}
