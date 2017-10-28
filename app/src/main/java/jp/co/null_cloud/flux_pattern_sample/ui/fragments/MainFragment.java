package jp.co.null_cloud.flux_pattern_sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import jp.co.null_cloud.flux_pattern_sample.databinding.FragmentMainBinding;
import jp.co.null_cloud.flux_pattern_sample.ui.application.FluxPatternSample;
import jp.co.null_cloud.flux_pattern_sample.ui.component.MainStore;
import jp.co.null_cloud.flux_pattern_sample.ui.views.adapter.TodoAdapter;

/**
 * 予定一覧を表示するFragment
 */

public class MainFragment extends Fragment {

    /** 表示するレイアウト */
    private FragmentMainBinding mBinding;

    /** Adapter */
    @Inject
    TodoAdapter mTodoAdapter;

    /** Store */
    @Inject
    MainStore mMainStore;

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

        //AdapterとStoreを生成しておく
        mTodoAdapter = ((FluxPatternSample) getActivity().getApplication()).getAppComponent().todoAdapter();
        mMainStore = ((FluxPatternSample) getActivity().getApplication()).getAppComponent().mainStore();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Viewを生成する
        mBinding = FragmentMainBinding.inflate(inflater, container, false);

        //Adapterを設定する
        mBinding.recyclerView.setAdapter(mTodoAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return mBinding.getRoot();
    }
}
