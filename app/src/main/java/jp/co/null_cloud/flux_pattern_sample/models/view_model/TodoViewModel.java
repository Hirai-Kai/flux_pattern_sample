package jp.co.null_cloud.flux_pattern_sample.models.view_model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import jp.co.null_cloud.flux_pattern_sample.BR;

/**
 * 予定を格納するViewModel
 */
public class TodoViewModel extends BaseObservable {

    /** 予定 */
    private String mTodo;

    /** 予定日 */
    private String mDate;

    @Bindable
    public String getTodo() {
        return mTodo;
    }

    public void setTodo(String todo) {
        mTodo = todo;
        notifyPropertyChanged(BR.todo);

    }

    @Bindable
    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
        notifyPropertyChanged(BR.date);
    }
}
