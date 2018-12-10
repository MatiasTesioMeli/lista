package com.example.mtesio.meliapp;

import com.example.mtesio.meliapp.Login.LoginPresenter;
import com.example.mtesio.meliapp.Login.LoginView;
import com.example.mtesio.meliapp.Login.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginView view;
    @Mock
    User model;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, model);
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getView());
    }

    @Test
    public void checkIfNavigateWorksFine() {
        presenter.navigate();
        verify(model, times(1)).setPassword(null);
        verify(model, times(1)).setUsername(null);
        verify(model, times(1)).logAuth();
        verify(view, times(1)).navigateToNextPage();

    }


}
