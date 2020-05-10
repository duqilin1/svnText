package movie.bw.com.svntext.presenter;

import movie.bw.com.svntext.base.BasePresenter;
import movie.bw.com.svntext.contract.ILoginContract;
import movie.bw.com.svntext.model.LoginModel;
import movie.bw.com.svntext.model.bean.LoginBean;
import movie.bw.com.svntext.model.bean.RegisterBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:15:19
 *@Description:${DESCRIPTION}
 * */
public class LoginPresenter extends BasePresenter<ILoginContract.IView> implements ILoginContract.IPresenter{

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginBean(String email, String pwd) {
        loginModel.getLoginBean(email, pwd, new ILoginContract.IModel.IModelCallBack() {
            @Override
            public void onLoginSeccess(LoginBean loginBean) {
                view.onLoginSeccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }

            @Override
            public void onRegisterSeccess(RegisterBean registerBean) {
                view.onRegisterSeccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }
        });
    }

    @Override
    public void getRegisterBean(String nickName, String email, String pwd, String code) {
        loginModel.getRegisterBean(nickName, email, pwd, code, new ILoginContract.IModel.IModelCallBack() {
            @Override
            public void onLoginSeccess(LoginBean loginBean) {
                view.onLoginSeccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }

            @Override
            public void onRegisterSeccess(RegisterBean registerBean) {
                view.onRegisterSeccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }
        });
    }
}
