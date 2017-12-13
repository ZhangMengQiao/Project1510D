package mvpframework.bwie.com.project1510d.view;

import mvpframework.bwie.com.project1510d.bean.RegBean;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IRegisterActivity {
    public String getPhone();
    public String getPwd();
    public void show(RegBean regBean);
}
