package mvpframework.bwie.com.project1510d.net;


public interface OnNetListener<T> {
    public void onSuccess(T t);

    public void onFailure(Exception e);
}
