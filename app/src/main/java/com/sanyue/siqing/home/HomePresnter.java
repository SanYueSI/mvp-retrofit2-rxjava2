package com.sanyue.siqing.home;

import android.os.SystemClock;

import com.sanyue.siqing.Base.BasePresnter;
import com.sanyue.siqing.MainActivity;
import com.sanyue.siqing.Network.APIInterface;
import com.sanyue.siqing.Network.BaseObserver;
import com.sanyue.siqing.Network.HttpUtils;
import com.sanyue.siqing.bean.BaseBean;
import com.sanyue.siqing.bean.SelectSpecial;

public class HomePresnter extends BasePresnter<HomeMode,MainActivity,HomeContract.P>{
    @Override
    public HomeContract.P getContract() {
        return new HomeContract.P() {
            @Override
            public void request() {
//                m.getConntract().home();
//                result(new UserBean("李四","11"));
//                Http h=new Http(HomePresnter.this);
//                h.get();
                HttpUtils
                        .getApiService(APIInterface.class)
                        .selectSpecial()
                        .compose(HttpUtils.applySchedulers())
                        .subscribe(new BaseObserver<SelectSpecial>(getView().getDisposable(),getView(),null) {
                    @Override
                    protected void success(SelectSpecial e) {
                        result(e);
                    }
                });
            }

            @Override
            public void result(BaseBean baseBean) {
                getView().getContract().result(baseBean);
            }
        };
    }

    @Override
    public HomeMode getModel() {
        return new HomeMode(this);
    }
}
