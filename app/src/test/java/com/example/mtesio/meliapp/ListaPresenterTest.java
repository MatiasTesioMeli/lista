package com.example.mtesio.meliapp;

import com.example.mtesio.meliapp.listadeitems.ListaDeItems;
import com.example.mtesio.meliapp.listadeitems.ListaPresenter;
import com.example.mtesio.meliapp.listadeitems.ListaView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ListaPresenterTest {

    @Mock
    ListaView view;
    @Mock
    ListaDeItems model;

    private ListaPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ListaPresenter(view, model);
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getView());
    }

}
