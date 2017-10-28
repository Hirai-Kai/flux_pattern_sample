package jp.co.null_cloud.flux_pattern_sample.ui.component;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import jp.co.null_cloud.flux_pattern_sample.flux.Action;
import jp.co.null_cloud.flux_pattern_sample.flux.Dispatcher;
import jp.co.null_cloud.flux_pattern_sample.models.dto.TodoData;

/**
 * ActionCreator
 */
public class MainActionCreator {

    /** Dispatcher */
    private Dispatcher mDispatcher;

    /**
     * コンストラクタ
     *
     * @param dispatcher Dispatcher
     */
    @Inject
    public MainActionCreator(@NonNull Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    /**
     * データを追加する
     *
     * @param todoData 追加するデータ
     */
    public void addTodo(@NonNull TodoData todoData) {
        mDispatcher.doOnMainThread(new Action("ADD", todoData));
    }

}
