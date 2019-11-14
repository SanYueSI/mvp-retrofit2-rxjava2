package com.sanyue.siqing.Network;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sanyue.siqing.R;

import java.lang.ref.WeakReference;


public class MyDiglog {

    private static Dialog loadingDialog;

    public static Dialog createLoadingDialog(Context context, String msg, boolean flag) {
        WeakReference<Context> weakReference = new WeakReference<>(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dialog_loading,null);
         loadingDialog=new Dialog(weakReference.get(),R.style.MyDialogStyle);
        TextView msgText=  view.findViewById(R.id.tipTextView);
        if(msg!=null){
            msgText.setText(msg);
        }
        loadingDialog.setContentView(view);
        loadingDialog.setCancelable(false);
        //是否可取消 dialog弹出后会点击屏幕或物理返回键，dialog不消失
//        loadingDialog.setCanceledOnTouchOutside(false);
// dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
        loadingDialog.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode== KeyEvent.KEYCODE_SEARCH)
            {
                return true;
            }
            else
            {
                return false; //默认返回 false
            }
        });

        return loadingDialog;

    }



}
