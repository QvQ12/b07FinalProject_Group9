package com.b07finalproject_group9.login.mvpbase;

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
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginFragment;
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginPresenter;
import com.b07finalproject_group9.objects.User;

@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {
    @Mock
    private ShopperLoginFragment shopperLoginFragment;

    @Test
    public void bindViewTest() {
        ShopperLoginPresenter P=new ShopperLoginPresenter();
        P.bindView(shopperLoginFragment);
        assertEquals(shopperLoginFragment,P.mView);
    }

    @Test
    public void BasePresenterConstructorTest(){
        ShopperLoginPresenter P = new ShopperLoginPresenter();
        assertNotNull(P.mModel);
        assertNull(P.mView);
    }
}