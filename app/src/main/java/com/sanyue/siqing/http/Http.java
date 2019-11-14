package com.sanyue.siqing.http;

import com.sanyue.siqing.bean.UserBean;
import com.sanyue.siqing.home.HomePresnter;

public class Http<P extends HomePresnter> {
    private P p;

    public Http(P p) {
        this.p = p;
    }

    public void get(){
        p.getContract().result(new UserBean("赵六","13"));
    }
}
