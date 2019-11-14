package com.sanyue.siqing.Base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends Activity {
    protected abstract int setLayoutId();
    protected CompositeDisposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        disposable = new CompositeDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("BaseActivity",disposable.size()+"");
        if(disposable!=null){
            disposable.dispose();
            disposable=null;
        }
    }
}
