package jp.co.null_cloud.flux_pattern_sample.models.dto;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 予定を格納するDTO
 */

public class TodoData {

    private String mTodo;

    private Date mDate;

    /**
     * Default Constructor
     */
    public TodoData() {
    }

    /**
     * Constructor
     *
     * @param todo 予定
     * @param date 予定日
     */
    public TodoData(@NonNull String todo, @NonNull Date date) {
        mTodo = todo;
        mDate = (Date) date.clone();
    }

    @NonNull
    public String getTodo() {
        return mTodo;
    }

    @NonNull
    public Date getDate() {
        return (Date) mDate.clone();
    }

    public void setTodo(@NonNull String todo) {
        mTodo = todo;
    }

    public void setDate(@NonNull Date date) {
        mDate = (Date) date.clone();
    }

    /**
     * 設定されている日時を規定のフォーマットに変換する
     *
     * @return 変換後の日時
     */
    @NonNull
    public String getSimpleDate() {
        return new SimpleDateFormat("MM/dd HH:mm ", Locale.JAPAN).format(mDate);
    }
}
