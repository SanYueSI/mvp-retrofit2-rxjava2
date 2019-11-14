package com.sanyue.siqing.Network;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.sanyue.siqing.R;
import com.sanyue.siqing.bean.BaseBean;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    private Context context;//弱引用
    private Dialog dialog;
    private CompositeDisposable disposable;

    public BaseObserver(CompositeDisposable disposable) {
        if(disposable!=null){
            this.disposable =  disposable;
        }
    }


    public BaseObserver(CompositeDisposable disposable,Context context,String msg) {
        if(disposable!=null){
            this.disposable =  disposable;
        }
        if(context!=null){
            this.context = context;
            dialog =  MyDiglog.createLoadingDialog(this.context,msg,false);
        }
    }

    //开始订阅 第一个执行的
    @Override
    public void onSubscribe(Disposable d) {
        if(dialog!=null && !dialog.isShowing()){
            dialog.show();
        }
        if(disposable!=null){
            disposable.add(d);
        }
    }
    //请求成功
    @Override
    public void onNext(T t) {
        if(((BaseBean)t).getStatus().equals("1")){
            success(t);
        }else if(((BaseBean)t).getStatus().equals("2")){
            // token 失效 重新登录
//            context.startActivity();
        }else {
            if(this.context!=null) {
                ToastUitl.show(this.context, ((BaseBean)t).getMessage(), R.drawable.ic_error);
            }
        }
    }

    //请求错误
    @Override
    public void onError(Throwable t) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
        if (t instanceof NetworkErrorException ||
                t instanceof UnknownHostException
                || t instanceof ConnectException) {
            if(this.context!=null) {
                ToastUitl.show(this.context, "网络异常", R.drawable.ic_error);
            }

        } else if (t instanceof SocketTimeoutException
                || t instanceof InterruptedIOException
                || t instanceof TimeoutException) {
        } else if (t instanceof JsonSyntaxException) {
            Log.e("BaseObserver", "JSON解析失败");
        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {   //  解析错误
            Log.e("BaseObserver", "解析错误");
        } else {
            if(this.context!=null){
                ToastUitl.show(this.context, "加载失败", R.drawable.ic_error);
            }

        }

    }
    //完成
    @Override
    public void onComplete() {
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
        dialog = null;
    }
    protected abstract void success(T e);

}
