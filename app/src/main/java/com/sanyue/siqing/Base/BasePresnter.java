package com.sanyue.siqing.Base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresnter<M extends BaseMode,V extends BaseView,CONTRACT> {
    protected M m;
    private WeakReference<V> weakReference;
    private WeakReference<CompositeDisposable> disposable;

    public void unBingView() {
        if(disposable!=null &&
                disposable.get()!=null
                && disposable.get().size()>0){
            disposable.get().dispose();
            disposable = null;
        }
        if(weakReference !=null){
            weakReference.clear();
            weakReference=null;
            System.gc();
        }

    }
    public void bingView(V v,CompositeDisposable d) {
        weakReference = new WeakReference<>(v);
        v.getContract();
        disposable = new WeakReference<>(d);

    }

    public BasePresnter() {
        this.m = getModel() ;
    }

    public V getView(){
        if (weakReference!=null){
            return weakReference.get();
        }
        return null;
    }
    public abstract CONTRACT getContract();
    public abstract M getModel();

}
