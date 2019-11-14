package com.sanyue.siqing.Base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseView<P extends  BasePresnter,CONTRACT> extends Activity {
    protected P p;
    private CompositeDisposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p=getPresnter();
        p.bingView(this, getDisposable());
    }

    public abstract CompositeDisposable getDisposable();


    public abstract P getPresnter();

    public abstract CONTRACT getContract();
    public void error(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unBingView();
    }
}
