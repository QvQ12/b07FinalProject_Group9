package com.b07finalproject_group9.login.shopperlogin;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.login.ownerlogin.OwnerLoginFragment;
import com.b07finalproject_group9.login.ownerlogin.OwnerLoginModel;
import com.b07finalproject_group9.login.ownerlogin.OwnerLoginPresenter;
import com.b07finalproject_group9.objects.User;

import java.util.concurrent.CompletableFuture;


@RunWith(MockitoJUnitRunner.class)
public class ShopperLoginPresenterTest {
    @Mock
    private ShopperLoginModel shopperLoginModel;

    @Mock
    private ShopperLoginFragment shopperLoginFragment;

    @Mock
    private User user;

    @Test
    public void getmModelInstanceTest(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        assertNotNull(P.getmModelInstance());
    }

    @Test
    public void performOwnerLoginSuccessTest1(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        P.mView=shopperLoginFragment;
        P.mModel=shopperLoginModel;
        when(shopperLoginModel.loginShopper(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performShopperLogin(anyString(),anyString());
        verify(shopperLoginFragment).successView();
        verify(shopperLoginFragment,never()).unsuccessView();
    }

    @Test
    public void performOwnerLoginSuccessTest2(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        P.mView=shopperLoginFragment;
        P.mModel=shopperLoginModel;
        MainActivity.currUser=null;
        when(shopperLoginModel.loginShopper(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performShopperLogin(anyString(),anyString());
        assertNotNull(MainActivity.currUser);
    }

    @Test
    public void performOwnerLoginUnSuccessTest1(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        P.mView=shopperLoginFragment;
        P.mModel=shopperLoginModel;
        when(shopperLoginModel.loginShopper(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performShopperLogin(anyString(),anyString());
        verify(shopperLoginFragment,never()).successView();
        verify(shopperLoginFragment).unsuccessView();
    }

    @Test
    public void performOwnerLoginUnSuccessTest2(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        P.mView=shopperLoginFragment;
        P.mModel=shopperLoginModel;
        MainActivity.currUser = user;
        when(shopperLoginModel.loginShopper(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performShopperLogin(anyString(),anyString());
        assertTrue(MainActivity.currUser==user);
    }
}