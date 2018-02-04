package com.genisys.toolbox;
import android.content.*;
import android.net.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.genisys.toolbox.*;
import com.pgyersdk.feedback.*;
import java.io.*;

public class FanyiActivity extends AppCompatActivity
{
	

		// 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
	private static final String APP_ID = "20171006000086509";
		private static final String SECURITY_KEY = "0Aiwqq9qclt5zv83QE2D";


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fanyi);

		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.talkEditText2);
		inputLayout.setHint("请输入qq号码：");

        final EditText editText = inputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after)
				{

				}

				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count)
				{
					Log.e("TAG", s.length() + "");
					if (s.length() > 11)
					{//字符超过5个时，出现EditText提示
						inputLayout.setError("字符不能超过12个");
						inputLayout.setErrorEnabled(true);
					}
					else
					{
						inputLayout.setErrorEnabled(false);
					}
				}

				@Override
				public void afterTextChanged(Editable s)
				{

				}
			});

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
		fab.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view)
				{
					final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.talkEditText1);
					final EditText editText = inputLayout.getEditText();
					String yt=editText.getText().toString();
					if(yt.trim().length()==0)
					{
						Snackbar.make(view, "你什么都没输入", Snackbar.LENGTH_LONG)

							.setAction("Action", null).show();
					}
					else
					{
						String ytr="mqqwpa://im/chat?chat_type=wpa&uin="+yt+"&version=1";
						startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(ytr)));
					}
				}});
	}
	public void sttalk(View view) 
	{
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.talkEditText2);
		final EditText editText = inputLayout.getEditText();
		String yt=editText.getText().toString();
		if(yt.trim().length()==0)
		{
			Snackbar.make(view, "你什么都没输入", Snackbar.LENGTH_LONG)

				.setAction("Action", null).show();
		}
		else
		{
			TransApi api = new TransApi(APP_ID, SECURITY_KEY);
			String query = +yt+;
			
		
			
			try
			{
				String s =api.getTransResult(query, "auto", "en").toString();
				Snackbar.make(view, s, Snackbar.LENGTH_LONG)

					.setAction("Action", null).show();
			}
			catch (UnsupportedEncodingException e)
			{}
			
			}
			
			}
		
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
		PgyFeedbackShakeManager.setShakingThreshold(1000);

		// 以对话框的形式弹出，对话框只支持竖屏
		PgyFeedbackShakeManager.register(FanyiActivity.this);

		// 以Activity的形式打开，这种情况下必须在AndroidManifest.xml配置FeedbackActivity
		// 打开沉浸式,默认为false
		// FeedbackActivity.setBarImmersive(true);
		//PgyFeedbackShakeManager.register(MainActivity.this, true); 相当于使用Dialog的方式；
		PgyFeedbackShakeManager.register(FanyiActivity.this, false);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		PgyFeedbackShakeManager.unregister();
	}
	public static boolean isNetworkAvailable(AppCompatActivity activity) {
		Context context = activity.getApplicationContext();

		ConnectivityManager connectivityManager = (ConnectivityManager) context
			.getSystemService(Context.CONNECTIVITY_SERVICE);

		if(connectivityManager == null) {
			return false;
		}else {
			NetworkInfo[]networkInfo = connectivityManager.getAllNetworkInfo();

			if(networkInfo != null && networkInfo.length > 0) {
				for(int i = 0; i < networkInfo.length; i++) {
					if(networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	

}
