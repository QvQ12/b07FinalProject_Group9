package com.b07finalproject_group9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import android.os.Build;

import com.google.firebase.FirebaseApp;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P)
public class ExampleUnitTest {
        @Test
        public void testMyMethod() {
            DatabaseModel d = new DatabaseModel();
            d.storeSignUp("a","b");
        }
    }