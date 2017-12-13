package mvpframework.bwie.com.project1510d.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import mvpframework.bwie.com.project1510d.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class MyView extends LinearLayout {
    private static EditText editText;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.seach, this);
        editText = view.findViewById(R.id.edit);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //得到输入值
    public String getEditText(){
        return editText.getText().toString().trim();

    }
    //输入框回车事件
    public void  setEditTextOnClient(TextView.OnEditorActionListener onClient)
    {
        // editText.setOnEditorActionListener
        editText.setOnEditorActionListener(onClient);
    }
}
