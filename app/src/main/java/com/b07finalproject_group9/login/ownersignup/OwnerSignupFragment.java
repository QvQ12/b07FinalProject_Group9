package com.b07finalproject_group9.login.ownersignup;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.login.ownerlogin.OwnerLoginFragment;
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginFragment;
import com.b07finalproject_group9.login.shoppersignup.ShopperSignupFragment;
import com.b07finalproject_group9.login.mvpbase.BaseFragment;
import com.b07finalproject_group9.owner.OwnerDashboardFragment;

import java.security.acl.Owner;

public class OwnerSignupFragment extends BaseFragment<OwnerSignupPresenter> {
    private void openShopperSignup(){
        Fragment f = new ShopperSignupFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }

    private void openOwnerLogin(){
        Fragment f = new OwnerLoginFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }



    private void  openShopperLogin(){
        Fragment f = new ShopperLoginFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }
    @Override
    public int getContentViewID() {
        return R.layout.ownersignup;
    }



    @Override
    public void initListener(View view) {
        Button btnSignUp = view.findViewById(R.id.owner_signup_button);
        EditText storename_editText = view.findViewById(R.id.storename_editText);
        EditText username_editText = view.findViewById(R.id.username_editText);
        EditText password_editText = view.findViewById(R.id.password_editText);
        Spinner spinner = view.findViewById(R.id.spinner);
        Button menu_button = view.findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerSignupFragment.this.getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner.getSelectedItem().toString().contains("shopper signup")){
                    openShopperSignup();
                }

                if(spinner.getSelectedItem().toString().contains("owner login")){
                    openOwnerLogin();
                }


                if(spinner.getSelectedItem().toString().contains("shopper login")){
                    openShopperLogin();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Nothing
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String storename = storename_editText.getText().toString();
                String username = username_editText.getText().toString();
                String password = password_editText.getText().toString();
                mPresenter.performOwnerSignUp(storename, username, password);
            }
        });
    }

    @Override
    public OwnerSignupPresenter getmPresenterInstance() {
        return new OwnerSignupPresenter();
    }

    @Override
    public void initSpinner(View view) {
        Spinner spinner;
        spinner = (Spinner) view.findViewById(R.id.spinner);
        if(spinner!=null)spinner.setSelection(3);
    }

    @Override
    public void successView() {
        Fragment f = new OwnerDashboardFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }

    @Override
    public void unsuccessView() {
        Toast.makeText(getActivity(), "Signup Unsuccessful",
                Toast.LENGTH_SHORT).show();
    }
}
