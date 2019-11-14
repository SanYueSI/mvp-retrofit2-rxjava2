package com.sanyue.siqing.Network;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sanyue.siqing.R;

import java.lang.ref.WeakReference;


/**
 * Create by YIp DATE 2018/10/31
 */
public class ToastUitl {

    private static Toast toast;

    public static void show(Context mContext,final String tvStr){
        showToastWithImg(mContext,tvStr,-1);
    }
    public static void show(Context mContext,final String tvStr,int imageResource){
        showToastWithImg(mContext,tvStr,imageResource);
    }

    /**
     * 显示有image的toast 这是个view
     */
    public static void  showToastWithImg(Context mContext, final String tvStr, final int imageResource) {

        WeakReference<Context> weakReference = new WeakReference<>(mContext);

        if (toast == null) {
            toast = new Toast(weakReference.get());
        }
        if(mContext==null) return;
        View view = LayoutInflater.from(mContext).inflate(R.layout.toast_view, null);
        TextView tv =  view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
        ImageView iv =  view.findViewById(R.id.toast_custom_iv);
        if (imageResource > 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imageResource);
        } else {
            iv.setVisibility(View.GONE);
        }
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}