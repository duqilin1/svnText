package movie.bw.com.svntext.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/*
 *@auther:杜其林
 *@Date: 2020/4/17
 *@Time:21:25
 *@Description:${DESCRIPTION}
 * */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView{
    protected P mPresenter;
    private View inflate;
    protected boolean isinitView = false;
    protected boolean isinitData = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("dql", "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("dql", "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(inflater.getContext()).inflate(layoutId(), null);
        Log.d("dql", "onCreateView: ");
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        ButterKnife.bind(this,inflate);
        initView(inflate);
        isinitView = true;
        doNetWork();
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P providePresenter();

    protected abstract int layoutId();

    private void doNetWork(){
        if (getUserVisibleHint()){
            initData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isinitView){
            initData();
            isinitData = true;
        }
    }

    protected abstract void initData();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("dql", "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("dql", "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("dql", "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("dql", "onPause: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detach();
        }
        Log.d("dql", "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("dql", "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("dql", "onDetach: ");
    }
}
