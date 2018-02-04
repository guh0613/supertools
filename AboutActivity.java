package com.genisys.toolbox;
import android.os.*;
import android.view.*;
import com.pgyersdk.update.*;
import com.pgyersdk.javabean.*;
import android.content.*;
import com.pgyersdk.feedback.*;
import android.support.v7.widget.*;
import com.pgyersdk.activity.*;
import com.pgyersdk.views.*;
import com.pgyersdk.update.*;
import android.support.v7.app.*;


public class AboutActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);}
	
		

		
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();

			// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
			PgyFeedbackShakeManager.setShakingThreshold(1000);

			// 以对话框的形式弹出，对话框只支持竖屏
			PgyFeedbackShakeManager.register(AboutActivity.this);

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
	
	
	public void newi(View view)
	{
		PgyUpdateManager.register(AboutActivity.this,
			new UpdateManagerListener() {

				@Override
				public void onUpdateAvailable(final String result) {

					// 将新版本信息封装到AppBean中
					final AppBean appBean = getAppBeanFromString(result);
					new AlertDialog.Builder(AboutActivity.this)
						.setTitle("更新")
						.setMessage("应用有新版本了，要不要去更新?")
						.setNegativeButton(
						"确定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(
								DialogInterface dialog,
								int which) {
								startDownloadTask(
									AboutActivity.this,
									appBean.getDownloadURL());
							}
						}).show();
				}

				@Override
				public void onNoUpdateAvailable() {
					new AlertDialog.Builder(AboutActivity.this)
						.setTitle("更新")
						.setMessage("已经是最新版本").show();
						
				}
			});}
public void ytr(View view)
{
	
	PgyFeedback.getInstance().showDialog(AboutActivity.this);
	
// 设置颜色选择器的背景色
	
}
public void ban(View view)
{
	Intent rew=new Intent(this,BanquanActivity.class);
	startActivity(rew);
}
}

