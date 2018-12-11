package com.example.mtesio.meliapp;

import com.example.mtesio.meliapp.item.ItemModel;
import com.example.mtesio.meliapp.item.ItemPresenter;
import com.example.mtesio.meliapp.item.ItemView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ItemPresenterTest {

    @Mock
    ItemView view;
    @Mock
    ItemModel model;

    private ItemPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ItemPresenter(view, model);
    }

    @Test
    public void checkIfTheViewIsDestroyed() {
        presenter.onDestroy();
        assertNull(presenter.getView());
    }

    @Test
    public void checkIfNavigateWorks() {
        presenter.navigate();
        assertNull(presenter.getView());
    }

}
