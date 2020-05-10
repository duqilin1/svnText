package movie.bw.com.svntext.contract;

import movie.bw.com.svntext.model.bean.LoginBean;
import movie.bw.com.svntext.model.bean.RegisterBean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:15:12
 *@Description:${DESCRIPTION}
 * */
public interface ILoginContract {

    interface IView{
        void onLoginSeccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);

        void onRegisterSeccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable throwable);
    }

    interface IPresenter{
        void getLoginBean(String email,String pwd);

        void getRegisterBean(String nickName,String email,String pwd,String code);
    }

    interface IModel{
        void getLoginBean(String email,String pwd,IModelCallBack iModelCallBack);
        void getRegisterBean(String nickName,String email,String pwd,String code,IModelCallBack iModelCallBack);

        interface IModelCallBack{
            void onLoginSeccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
            void onRegisterSeccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable throwable);
        }
    }
}
