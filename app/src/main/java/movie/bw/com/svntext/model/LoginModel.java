package movie.bw.com.svntext.model;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import movie.bw.com.svntext.contract.ILoginContract;
import movie.bw.com.svntext.model.bean.LoginBean;
import movie.bw.com.svntext.model.bean.RegisterBean;
import movie.bw.com.svntext.util.NetUtil;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:15:15
 *@Description:${DESCRIPTION}
 * */
public class LoginModel implements ILoginContract.IModel{

    @Override
    public void getLoginBean(String email, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApiService().LOGIN_BEAN_OBSERVABLE(email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallBack.onLoginSeccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRegisterBean(String nickName, String email, String pwd, String code, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApiService().REGISTER_BEAN_OBSERVABLE(nickName, email, pwd, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iModelCallBack.onRegisterSeccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
