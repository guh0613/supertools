package com.genisys.toolbox;

import android.os.*;
import android.view.*;
import android.support.v7.widget.*;
import android.content.*;
import android.net.*;
import android.support.v7.app.*;
import android.support.design.widget.*;
import android.widget.*;
import android.text.*;
import android.util.*;
import android.preference.*;
import com.pgyersdk.feedback.*;

public class TalkActivity extends AppCompatActivity
{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.talk);
		
		 
		
		final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.talkEditText1);
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
			
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
	}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
		PgyFeedbackShakeManager.setShakingThreshold(1000);

		// 以对话框的形式弹出，对话框只支持竖屏
		PgyFeedbackShakeManager.register(TalkActivity.this);

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
}
