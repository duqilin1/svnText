package movie.bw.com.svntext.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseActivity;
import movie.bw.com.svntext.contract.ILoginContract;
import movie.bw.com.svntext.model.bean.LoginBean;
import movie.bw.com.svntext.model.bean.RegisterBean;
import movie.bw.com.svntext.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginContract.IView {

    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_yzm)
    EditText edYzm;
    @BindView(R.id.but)
    Button but;
    @BindView(R.id.text_dl)
    TextView textDl;
    @BindView(R.id.but_log)
    Button butLog;
    @BindView(R.id.but_wx)
    Button butWx;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSeccess(LoginBean loginBean) {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSeccess(RegisterBean registerBean) {

    }

    @Override
    public void onRegisterFailure(Throwable throwable) {

    }

    @OnClick({R.id.but, R.id.text_dl, R.id.but_log, R.id.but_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but:
                break;
            case R.id.text_dl:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.but_log:
                String email = edEmail.getText().toString();
                String pwd = edYzm.getText().toString();
                mPresenter.getLoginBean(email,pwd);
                break;
            case R.id.but_wx:
                break;
        }
    }
}
