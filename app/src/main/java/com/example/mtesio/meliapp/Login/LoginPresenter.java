package com.example.mtesio.meliapp.Login;

public class LoginPresenter {

    private User user;
    private LoginView view;

    public LoginPresenter(LoginView view, User user){
        this.view = view;
        this.user = user;
    }

    public void onDestroy() {
        view = null;
    }

    public void navigate(){
        if(view != null){
            user.setUsername(view.getPassword());
            user.setPassword(view.getPassword());
            user.logAuth();
            view.navigateToNextPage();
        }
    }

    public LoginView getView() {
        return view;
    }
}
