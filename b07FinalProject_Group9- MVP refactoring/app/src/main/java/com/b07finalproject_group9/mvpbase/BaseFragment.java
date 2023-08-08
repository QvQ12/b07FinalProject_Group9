package com.b07finalproject_group9.mvpbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    public P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewID(), container, false);
        initSpinner(view);
        initListener(view);

        mPresenter=getmPresenterInstance();
        mPresenter.bindView(this);
        return  view;
    }



    public abstract int getContentViewID();
    public abstract void initListener(View view);
    public abstract P getmPresenterInstance();
    public abstract void initSpinner(View view);
    public abstract void successView();
    public abstract void unsuccessView();
}
