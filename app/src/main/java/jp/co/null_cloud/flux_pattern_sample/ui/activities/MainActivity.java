package jp.co.null_cloud.flux_pattern_sample.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;

import javax.inject.Inject;

import jp.co.null_cloud.flux_pattern_sample.R;
import jp.co.null_cloud.flux_pattern_sample.databinding.ActivityMainBinding;
import jp.co.null_cloud.flux_pattern_sample.models.dto.TodoData;
import jp.co.null_cloud.flux_pattern_sample.ui.application.FluxPatternSample;
import jp.co.null_cloud.flux_pattern_sample.ui.component.MainActionCreator;
import jp.co.null_cloud.flux_pattern_sample.ui.fragments.MainFragment;

/**
 * 予定一覧を表示するActivity
 * <p>
 * ここでは各種イベントのキャッチとFragmentの制御を行い、UI関係は基本的に操作しない
 */

public class MainActivity extends AppCompatActivity {

    /** 表示するレイアウト */
    private ActivityMainBinding mBinding;

    /** 表示するFragment */
    private final MainFragment mFragment = MainFragment.newInstance();

    /** ActionCreator */
    @Inject
    MainActionCreator mActionCreator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mActionCreator = ((FluxPatternSample) getApplication()).getAppComponent().mainActionCreator();

        //Fragmentを表示する
        getSupportFragmentManager().beginTransaction()
                .replace(mBinding.contains.getId(), mFragment)
                .commit();

        //ボタンタップイベント
        mBinding.floatingActionButton.setOnClickListener(view -> {
            mActionCreator.addTodo(new TodoData("todoData", new Date(System.currentTimeMillis())));
        });
    }
}
