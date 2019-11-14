package com.sanyue.siqing.home;

import com.sanyue.siqing.Base.BaseMode;
import com.sanyue.siqing.Network.APIInterface;
import com.sanyue.siqing.Network.BaseObserver;
import com.sanyue.siqing.Network.HttpUtils;
import com.sanyue.siqing.bean.SelectSpecial;
import com.sanyue.siqing.bean.UserBean;

public class HomeMode extends BaseMode<HomePresnter,HomeContract.M> {
    public HomeMode(HomePresnter homePresnter) {
        super(homePresnter);
    }

    @Override
    public HomeContract.M getConntract() {
        return new HomeContract.M() {
            @Override
            public void home() {

//                p.getContract().result(new UserBean("张三","18"));
//           HttpUtils
//                        .getApiService(APIInterface.class)
//                        .selectSpecial()
//                        .compose(HttpUtils.applySchedulers())
//                        .subscribe(new BaseObserver<SelectSpecial>(getView().getDisposable(),getView(),null) {
//                    @Override
//                    protected void success(SelectSpecial e) {
//                        result(e);
//                    }
//                });
            }
        };
    }
}
