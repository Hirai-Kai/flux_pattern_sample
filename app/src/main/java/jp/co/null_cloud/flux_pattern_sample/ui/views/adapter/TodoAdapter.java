package jp.co.null_cloud.flux_pattern_sample.ui.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import jp.co.null_cloud.flux_pattern_sample.R;
import jp.co.null_cloud.flux_pattern_sample.databinding.HolderTodoBinding;
import jp.co.null_cloud.flux_pattern_sample.models.dto.TodoData;

/**
 * 予定一覧を表示するAdapter
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoHolder> {

    /** Context */
    private final Context mContext;

    /** 予定一覧 */
    private List<TodoData> mDataList;

    /**
     * Constructor
     *
     * @param context Context
     */
    public TodoAdapter(@NonNull Context context) {
        mContext = context;
    }

    @Override
    public TodoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TodoHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TodoHolder holder, int position) {
        if (null != mDataList && position < mDataList.size()) {
            //念のためnullチェックと位置のチェック
            holder.setTodo(mDataList.get(position));

            //ボタンタップ時のイベントを設定する
            holder.getBinding().removeTodoData.setOnClickListener(v -> {
                removeItem(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mDataList ? 0 : mDataList.size();
    }

    /**
     * 表示する予定を設定する
     *
     * @param item 予定一覧
     */
    public void setItem(@NonNull List<TodoData> item) {
        mDataList = new ArrayList<>(item);
    }

    /**
     * 予定を追加する
     *
     * @param todoData 予定
     */
    public void addItem(@NonNull TodoData todoData) {
        if (null == mDataList) {
            mDataList = new ArrayList<>();
        }

        mDataList.add(todoData);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        if (index < 0 || mDataList.size() - 1 < index) {
            return;
        }

        mDataList.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(index, mDataList.size());
    }

    /**
     * リストに表示するViewHolder
     */
    static class TodoHolder extends RecyclerView.ViewHolder {

        /** 表示するレイアウト */
        private HolderTodoBinding mBinding;

        /**
         * Constructor
         *
         * @param itemView View
         */
        TodoHolder(View itemView) {
            super(itemView);
            mBinding = HolderTodoBinding.bind(itemView);
        }

        /**
         * Viewを取得する
         *
         * @return View
         */
        public HolderTodoBinding getBinding() {
            return mBinding;
        }

        /**
         * 予定を設定する
         *
         * @param todo 予定
         */
        void setTodo(@NonNull TodoData todo) {
            mBinding.setTodoData(todo);
        }

        /**
         * 対応するViewを生成する
         *
         * @param parent ViewGroup
         * @return View
         */
        public static TodoHolder create(ViewGroup parent) {
            return new TodoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_todo, parent, false));
        }
    }
}
