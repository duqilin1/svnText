package movie.bw.com.svntext.base;

/*
 *@auther:杜其林
 *@Date: 2020/4/17
 *@Time:19:55
 *@Description:${DESCRIPTION}
 * */
public abstract class BasePresenter<V> implements IBaseView{
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }
}
