package com.b07finalproject_group9.login.mvpbase;

public abstract class BasePresenter<V extends BaseFragment,M extends BaseModel> {
    public V mView;
    public M mModel;

    public BasePresenter(){
        this.mModel=getmModelInstance();
    }

    public void bindView(V mview){
        this.mView=mview;
    }

    public abstract M getmModelInstance();
}
