package com.sanyue.siqing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sanyue.siqing.Base.BaseView;
import com.sanyue.siqing.Network.APIInterface;
import com.sanyue.siqing.Network.HttpUtils;
import com.sanyue.siqing.bean.BaseBean;
import com.sanyue.siqing.bean.SelectSpecial;
import com.sanyue.siqing.bean.UserBean;
import com.sanyue.siqing.home.HomeContract;
import com.sanyue.siqing.home.HomePresnter;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseView<HomePresnter, HomeContract.V> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public CompositeDisposable getDisposable() {
        return new CompositeDisposable();
    }

    @Override
    public HomePresnter getPresnter() {
        return new HomePresnter();
    }

    @Override
    public HomeContract.V getContract() {
        return new HomeContract.V<SelectSpecial>() {
            @Override
                public void result(SelectSpecial bean) {
                    Toast.makeText(MainActivity.this, bean.getData().size()+"你好",Toast.LENGTH_LONG).show();
                }
        };
    }


    public void click(View view) {
        p.getContract().request();
//        Toast.makeText(this,"111",1).show();
    }
}
