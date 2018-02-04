package com.genisys.toolbox;

import android.os.*;
import android.view.*;
import android.net.*;
import android.support.v7.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.design.widget.*;
import android.widget.*;
import com.pgyersdk.feedback.*;

public class SeaActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sea);
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		inputLayout.setHint("请输入搜索内容:");

        
	}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
		PgyFeedbackShakeManager.setShakingThreshold(1000);

		// 以对话框的形式弹出，对话框只支持竖屏
		PgyFeedbackShakeManager.register(SeaActivity.this);

		// 以Activity的形式打开，这种情况下必须在AndroidManifest.xml配置FeedbackActivity
		// 打开沉浸式,默认为false
		// FeedbackActivity.setBarImmersive(true);
		//PgyFeedbackShakeManager.register(MainActivity.this, true); 相当于使用Dialog的方式；
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		PgyFeedbackShakeManager.unregister();
	}
	public void baidu(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="https://www.baidu.com/from=844b/s?word="+yui+"&ts=5030410&t_kt=0&ie=utf-8&fm_kl=021394be2f&rsv_iqid=0220112808&rsv_t=b4d5XteuAhcjh0%252FBpV4CUI%252By4g%252FRoDIbKeYJi2vdysRpBr4l6MnGs8SWDw&sa=ib&ms=1&rsv_pq=0220112808&rsv_sug4=5420&ss=110&inputT=551";
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
	public void ha(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="https://m.so.com/s?q="+yui+"&src=msearch_next_input&srcg=home_next";
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
	public void gou(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="https://m.sogou.com/web/searchList.jsp?uID=7Q_o1AKCwEIAyrte&v=5&from=index&w=1274&t=1506216396321&s_t=1506216402479&s_from=index&keyword="+yui+"&pg=webSearchList&suguuid=3dc92958-9f4d-4a96-b14f-1e28c18c6f4e&sugsuv=AAEhNhxoGwAAAAqZMC0wiwMAEwQ%3D&sugtime=1506216402493";
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
	public void zhi(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="https://zhidao.baidu.com/index/?fr=&word="+yui+"&step=1";
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
	public void ma(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="http://m.sm.cn/s?q="+yui+"&uc_param_str=dnntnwvepffrgibijbprsvdsdichme&from=smor&safe=1&snum=6";
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
	public void bil(View view)
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.seatalkEditText1);
		final EditText editText = inputLayout.getEditText();
		String yui=editText.getText().toString();
		String uyt="http://m.bilibili.com/search.html?keyword="+yui;
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uyt)));
	}
}
