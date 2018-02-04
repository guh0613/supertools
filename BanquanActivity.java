package com.genisys.toolbox;

import android.os.*;
import android.view.*;
import android.content.*;
import android.net.*;
import android.widget.*;
import android.support.v7.app.*;
import com.pgyersdk.feedback.*;

public class BanquanActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banquan);
	}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
		PgyFeedbackShakeManager.setShakingThreshold(1000);

		// 以对话框的形式弹出，对话框只支持竖屏
		PgyFeedbackShakeManager.register(BanquanActivity.this);

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
	public void joinqun(View view)
	{
		joinQQGroup("tOzUCwzASc0u_tnxMlSvSU5pGopIlFK7");}
		
	/****************
	 *
	 * 发起添加群流程。群号：point-java交流群(615057487) 的 key 为： cH5dSLMoz_r7EWQCsbYQdhE7u50EwCwQ
	 * 调用 joinQQGroup(cH5dSLMoz_r7EWQCsbYQdhE7u50EwCwQ) 即可发起手Q客户端申请加群 point-java交流群(615057487)
	 *
	 * @param key 由官网生成的key
	 * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
	 ******************/
	public boolean joinQQGroup(String key) {
		Intent intent = new Intent();
		intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
		// 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		try {
			startActivity(intent);
			return true;
		} catch (Exception e) {
			Toast.makeText(this,"未安装手机qq或版本不支持",Toast.LENGTH_SHORT).show();// 未安装手Q或安装的版本不支持
			return false;
		}
	}
	public void talk(View view)
	{
		String ytr="mqqwpa://im/chat?chat_type=wpa&uin=1123691559&version=1";
		startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(ytr)));
	}
	
}
