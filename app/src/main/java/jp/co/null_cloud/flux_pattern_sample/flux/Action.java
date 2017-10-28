package jp.co.null_cloud.flux_pattern_sample.flux;

import android.support.annotation.NonNull;

/**
 * 各種Actionを格納するクラス
 */
public final class Action {

    /** Actionのキー */
    private final String mKey;

    /** Actionに格納された値 */
    private final Object mValue;

    /**
     * コンストラクタ
     *
     * @param key   キー
     * @param value 値
     */
    public Action(@NonNull String key, @NonNull Object value) {
        mKey = key;
        mValue = value;
    }

    /**
     * キーを取得する
     *
     * @return キー
     */
    @NonNull
    public String getKey() {
        return mKey;
    }

    /**
     * 格納された値を取得する
     *
     * @return 格納された値
     */
    @NonNull
    public Object getValue() {
        return mValue;
    }
}
