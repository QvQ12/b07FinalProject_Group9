package com.b07finalproject_group9.login.shopperlogin;

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
import com.b07finalproject_group9.login.ownersignup.OwnerSignupFragment;
import com.b07finalproject_group9.login.shoppersignup.ShopperSignupFragment;
import com.b07finalproject_group9.login.mvpbase.BaseFragment;
import com.tempfragments.ShopperDashboard;

public class ShopperLoginFragment extends BaseFragment<ShopperLoginPresenter> {
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

    private void openOwnerSignup(){
        Fragment f = new OwnerSignupFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }


    @Override
    public int getContentViewID() {
        return R.layout.shopperlogin;
    }



    @Override
    public void initListener(View view) {
        EditText username_editText = view.findViewById(R.id.username_editText);
        EditText password_editText = view.findViewById(R.id.password_editText);
        Button btnLogin = view.findViewById(R.id.shopper_login_button);
        Spinner spinner = view.findViewById(R.id.spinner);
        Button menu_button = view.findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopperLoginFragment.this.getActivity(), MainActivity.class);
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

                if(spinner.getSelectedItem().toString().contains("owner signup")){
                    openOwnerSignup();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Nothing
            }
        });


        //Do Login On Clicking Login
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String username = username_editText.getText().toString();
                String password = password_editText.getText().toString();
                mPresenter.performShopperLogin(username, password);
            }
        });
    }

    @Override
    public ShopperLoginPresenter getmPresenterInstance() {
        return new ShopperLoginPresenter();
    }

    @Override
    public void initSpinner(View view) {
        Spinner spinner;
        spinner = (Spinner) view.findViewById(R.id.spinner);
        if(spinner!=null)spinner.setSelection(0);
    }

    @Override
    public void successView() {
        Fragment f = new ShopperDashboard();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
    }

    @Override
    public void unsuccessView() {
        Toast.makeText(getActivity(), "Login Unsuccessful",
                Toast.LENGTH_SHORT).show();
    }
}
