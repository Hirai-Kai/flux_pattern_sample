package jp.co.null_cloud.flux_pattern_sample.ui.views.adapter;

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
import jp.co.null_cloud.flux_pattern_sample.models.view_model.TodoViewModel;

/**
 * 予定一覧を表示するAdapter
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoHolder> {

    /** 予定一覧 */
    private List<TodoData> mDataList;

    /**
     * Constructor
     */
    public TodoAdapter() {
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

    /**
     * 予定を削除する
     *
     * @param index 削除する予定のポジション
     */
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
            TodoViewModel model = new TodoViewModel();
            model.setTodo(todo.getTodo());
            model.setDate(todo.getSimpleDate());
            mBinding.setViewModel(model);
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
