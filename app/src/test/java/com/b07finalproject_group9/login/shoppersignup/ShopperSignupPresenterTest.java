package com.b07finalproject_group9.login.shoppersignup;

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
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginFragment;
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginModel;
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginPresenter;
import com.b07finalproject_group9.objects.User;

import java.util.concurrent.CompletableFuture;

@RunWith(MockitoJUnitRunner.class)
public class ShopperSignupPresenterTest {
    @Mock
    private ShopperSignupModel shopperSignupModel;

    @Mock
    private ShopperSignupFragment shopperSignupFragment;

    @Mock
    private User user;

    @Test
    public void getmModelInstanceTest(){
        ShopperSignupPresenter P = new ShopperSignupPresenter();
        assertNotNull(P.getmModelInstance());
    }

    @Test
    public void performOwnerLoginSuccessTest1(){
        ShopperSignupPresenter P = new ShopperSignupPresenter();
        P.mView=shopperSignupFragment;
        P.mModel=shopperSignupModel;
        when(shopperSignupModel.signUpShopperUser(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performShopperSignUp(anyString(),anyString());
        verify(shopperSignupFragment).successView();
        verify(shopperSignupFragment,never()).unsuccessView();
    }

    @Test
    public void performOwnerLoginSuccessTest2(){
        ShopperSignupPresenter P = new ShopperSignupPresenter();
        P.mView=shopperSignupFragment;
        P.mModel=shopperSignupModel;
        MainActivity.currUser=null;
        when(shopperSignupModel.signUpShopperUser(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performShopperSignUp(anyString(),anyString());
        assertNotNull(MainActivity.currUser);
    }

    @Test
    public void performOwnerLoginUnSuccessTest1(){
        ShopperSignupPresenter P = new ShopperSignupPresenter();
        P.mView=shopperSignupFragment;
        P.mModel=shopperSignupModel;
        when(shopperSignupModel.signUpShopperUser(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performShopperSignUp(anyString(),anyString());
        verify(shopperSignupFragment,never()).successView();
        verify(shopperSignupFragment).unsuccessView();
    }

    @Test
    public void performOwnerLoginUnSuccessTest2(){
        ShopperSignupPresenter P = new ShopperSignupPresenter();
        P.mView=shopperSignupFragment;
        P.mModel=shopperSignupModel;
        MainActivity.currUser = user;
        when(shopperSignupModel.signUpShopperUser(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performShopperSignUp(anyString(),anyString());
        assertTrue(MainActivity.currUser==user);
    }
}