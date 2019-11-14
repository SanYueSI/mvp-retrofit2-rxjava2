package com.sanyue.siqing.Base;

public abstract class BaseMode<P extends BasePresnter,CONTRACT > {
    protected  P p; //调用 p中的回调result(T t);

    public BaseMode(P p) {
        this.p = p;
    }
    public abstract CONTRACT getConntract();
}
