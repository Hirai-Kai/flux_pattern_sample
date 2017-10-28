package jp.co.null_cloud.flux_pattern_sample.flux;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Actionを通知するDispatcher
 */
public final class Dispatcher {

    /** Actionを通知するSubject */
    private final Subject<Action> mSubject;

    /**
     * コンストラクタ
     */
    public Dispatcher() {
        mSubject = PublishSubject.create();
    }

    /**
     * Subjectを取得する
     *
     * @return Subject
     */
    public Subject<Action> getSubject() {
        return mSubject;
    }

    /**
     * メインスレッドでイベントを実行する
     *
     * @param rxAction 実行するAction
     */
    public void doOnMainThread(Action rxAction) {
        Observable.just(rxAction)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubject::onNext);
    }
}
