package com.b07finalproject_group9.login.mvpbase;

public abstract class BaseModel<P extends BasePresenter> {
    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter=mPresenter;
    }
}
