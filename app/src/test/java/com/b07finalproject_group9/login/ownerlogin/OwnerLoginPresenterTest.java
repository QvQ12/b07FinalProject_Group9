package com.b07finalproject_group9.login.ownerlogin;

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
import com.b07finalproject_group9.objects.User;

import java.util.concurrent.CompletableFuture;

@RunWith(MockitoJUnitRunner.class)
public class OwnerLoginPresenterTest {
    @Mock
    private OwnerLoginModel ownerLoginModel;

    @Mock
    private OwnerLoginFragment ownerLoginFragment;

    @Mock
    private User user;

    @Test
    public void getmModelInstanceTest(){
        OwnerLoginPresenter P = new OwnerLoginPresenter();
        assertNotNull(P.getmModelInstance());
    }

    @Test
    public void performOwnerLoginSuccessTest1(){
        OwnerLoginPresenter P = new OwnerLoginPresenter();
        P.mView=ownerLoginFragment;
        P.mModel=ownerLoginModel;
        when(ownerLoginModel.loginOwner(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performOwnerLogin(anyString(),anyString());
        verify(ownerLoginFragment).successView();
        verify(ownerLoginFragment,never()).unsuccessView();
    }

    @Test
    public void performOwnerLoginSuccessTest2(){
        OwnerLoginPresenter P = new OwnerLoginPresenter();
        P.mView=ownerLoginFragment;
        P.mModel=ownerLoginModel;
        MainActivity.currUser=null;
        when(ownerLoginModel.loginOwner(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(true);
                    return future;
                });
        P.performOwnerLogin(anyString(),anyString());
        assertNotNull(MainActivity.currUser);
    }

    @Test
    public void performOwnerLoginUnSuccessTest1(){
        OwnerLoginPresenter P = new OwnerLoginPresenter();
        P.mView=ownerLoginFragment;
        P.mModel=ownerLoginModel;
        when(ownerLoginModel.loginOwner(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performOwnerLogin(anyString(),anyString());
        verify(ownerLoginFragment,never()).successView();
        verify(ownerLoginFragment).unsuccessView();
    }

    @Test
    public void performOwnerLoginUnSuccessTest2(){
        OwnerLoginPresenter P = new OwnerLoginPresenter();
        P.mView=ownerLoginFragment;
        P.mModel=ownerLoginModel;
        MainActivity.currUser = user;
        when(ownerLoginModel.loginOwner(anyString(),anyString())).thenAnswer(
                invocation -> {
                    CompletableFuture<Boolean> future = new CompletableFuture<>();
                    future.complete(false);
                    return future;
                });
        P.performOwnerLogin(anyString(),anyString());
        assertTrue(MainActivity.currUser==user);
    }
}