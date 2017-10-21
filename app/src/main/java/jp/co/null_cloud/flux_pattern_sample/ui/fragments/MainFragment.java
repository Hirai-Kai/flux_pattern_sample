package jp.co.null_cloud.flux_pattern_sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.null_cloud.flux_pattern_sample.databinding.FragmentMainBinding;
import jp.co.null_cloud.flux_pattern_sample.models.dto.TodoData;
import jp.co.null_cloud.flux_pattern_sample.ui.views.adapter.TodoAdapter;

/**
 * 予定一覧を表示するFragment
 */

public class MainFragment extends Fragment {

    /** 表示するレイアウト */
    private FragmentMainBinding mBinding;

    /** Adapter */
    private TodoAdapter mTodoAdapter;

    //todo:test
    private final List<TodoData> testData = new ArrayList<TodoData>() {
        {
            add(new TodoData("todo", new Date(System.currentTimeMillis())));
            add(new TodoData("todo2", new Date(System.currentTimeMillis())));
            add(new TodoData("todo3", new Date(System.currentTimeMillis())));
            add(new TodoData("todo4", new Date(System.currentTimeMillis())));
            add(new TodoData("todo5", new Date(System.currentTimeMillis())));
        }
    };

    /**
     * インスタンスを生成する
     *
     * @return インスタンス
     */
    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTodoAdapter = new TodoAdapter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Viewを生成する
        mBinding = FragmentMainBinding.inflate(inflater, container, false);

        //Adapterを設定する
        //todo:test
        mTodoAdapter.setItem(testData);
        mBinding.recyclerView.setAdapter(mTodoAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
