package jp.co.null_cloud.flux_pattern_sample.ui.component;

import android.util.Log;

import javax.inject.Inject;

import jp.co.null_cloud.flux_pattern_sample.flux.Dispatcher;
import jp.co.null_cloud.flux_pattern_sample.models.dto.TodoData;
import jp.co.null_cloud.flux_pattern_sample.ui.views.adapter.TodoAdapter;

/**
 * Storeクラス
 */
public class MainStore {

    /**
     * コンストラクタ
     *
     * @param dispatcher Dispatcher
     * @param adapter    TodoAdapter
     */
    @Inject
    public MainStore(Dispatcher dispatcher, TodoAdapter adapter) {
        //イベントの受信を開始する
        dispatcher.getSubject().subscribe(action -> {
            switch (action.getKey()) {
                case "ADD":
                    //アイテム追加イベント
                    adapter.addItem((TodoData) action.getValue());
                    break;

                default:
                    Log.d("MainStore", "unknown action");
            }
        });
    }
}
