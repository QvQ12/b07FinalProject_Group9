package com.b07finalproject_group9.login.ownersignup;

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
public class OwnerSignupPresenterTest {
    @Mock
    private OwnerSignupModel ownerSignupModel;

    @Mock
    private OwnerSignupFragment ownerSignupFragment;

    @Mock
    private User user;

    @Test
    public void getmModelInstanceTest(){
        OwnerSignupPresenter P = new OwnerSignupPresenter();
        assertNotNull(P.getmModelInstance());
    }

    @Test
    public void performOwnerSignupSuccessTest1(){
        OwnerSignupPresenter P = new OwnerSignupPresenter();
        P.mView=ownerSignupFragment;
        P.mModel=ownerSignupModel;
        when(ownerSignupModel.signUpStoreOwner(anyString(),anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performOwnerSignUp(anyString(),anyString(),anyString());
        verify(ownerSignupFragment).successView();
        verify(ownerSignupFragment,never()).unsuccessView();
    }

    @Test
    public void performOwnerLoginSuccessTest2(){
        OwnerSignupPresenter P = new OwnerSignupPresenter();
        P.mView=ownerSignupFragment;
        P.mModel=ownerSignupModel;
        MainActivity.currUser=null;
        when(ownerSignupModel.signUpStoreOwner(anyString(),anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performOwnerSignUp(anyString(),anyString(),anyString());
        assertNotNull(MainActivity.currUser);
    }

    @Test
    public void performOwnerLoginUnSuccessTest1(){
        OwnerSignupPresenter P = new OwnerSignupPresenter();
        P.mView=ownerSignupFragment;
        P.mModel=ownerSignupModel;
        when(ownerSignupModel.signUpStoreOwner(anyString(),anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performOwnerSignUp(anyString(),anyString(),anyString());
        verify(ownerSignupFragment,never()).successView();
        verify(ownerSignupFragment).unsuccessView();
    }

    @Test
    public void performOwnerLoginUnSuccessTest2(){
        OwnerSignupPresenter P = new OwnerSignupPresenter();
        P.mView=ownerSignupFragment;
        P.mModel=ownerSignupModel;
        MainActivity.currUser = user;
        when(ownerSignupModel.signUpStoreOwner(anyString(),anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performOwnerSignUp(anyString(),anyString(),anyString());
        assertTrue(MainActivity.currUser==user);
    }
}