package jp.co.null_cloud.flux_pattern_sample.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jp.co.null_cloud.flux_pattern_sample.databinding.ActivityMainBinding;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //Fragmentを表示する
        getSupportFragmentManager().beginTransaction()
                .replace(mBinding.contains.getId(), mFragment)
                .commit();

        //ボタンタップイベント
        mBinding.floatingActionButton.setOnClickListener(view -> {

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
