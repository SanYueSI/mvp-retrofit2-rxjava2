package com.sanyue.siqing.home;

import com.sanyue.siqing.bean.BaseBean;
import com.sanyue.siqing.bean.SelectSpecial;

//将m v p层的业务处理 封装起来
public interface HomeContract {
    //mode层
    interface M{
        void home();
    }
//    view层
    interface V<T extends BaseBean>{
        void result(T t);
    }

    interface P<T extends BaseBean>{
        void request();
        void result(T t);
    }
}
