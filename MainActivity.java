package com.genisys.toolbox;


import android.os.*;
import android.view.*;
import android.content.*;
import com.pgyersdk.update.*;


import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.support.design.widget.*;

import android.widget.EditText;
import android.text.*;
import android.util.*;
import android.support.v4.widget.*;
import android.support.v4.view.*;
import com.pgyersdk.feedback.*;

public class MainActivity extends AppCompatActivity
{

	private long exitTime;
	private CoordinatorLayout mlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
 final Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
		

		PgyUpdateManager.setIsForced(false); //设置是否强制更新。true为强制更新；false为不强制更新（默认值）。
		PgyUpdateManager.register(this);
		//设置抽屉DrawerLayout
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
																		R.string.draw_open, R.string.draw_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置导航栏NavigationView的点击事件
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem) {
					switch (menuItem.getItemId()) 
					{
						case R.id.nav_blog:
							mlayout=(CoordinatorLayout) findViewById(R.id.mainCoordinatorLayout1);
							Snackbar.make(mlayout,"这里还在开发中", Snackbar.LENGTH_LONG)

								.setAction("知道了", new View.OnClickListener(){@Override
								public void onClick(View view)
								{}}).show();
								break;
								case R.id.nav_about:
							mlayout=(CoordinatorLayout) findViewById(R.id.mainCoordinatorLayout1);
							Snackbar.make(mlayout,"这里还在开发中,请前往右上角查看", Snackbar.LENGTH_LONG)

								.setAction("知道了", new View.OnClickListener(){@Override
									public void onClick(View view)
									{}}).show();
									break;
									case R.id.nav_version:
							new AlertDialog.Builder(MainActivity.this)
								.setTitle("版本信息")
								.setMessage("版本2.9新内容:1.重新优化编译的计算器，不一样的算法，更好的体验            2.加入翻译系统(技术支持：百度翻译)，目前编译了10%")
								.setNegativeButton("好的",new DialogInterface.OnClickListener(){
									@Override
									public void onClick(DialogInterface dialog,int which)
									{
										}

								}).show();
								break;
						case R.id.nav_sub1:
							mlayout=(CoordinatorLayout) findViewById(R.id.mainCoordinatorLayout1);
							Snackbar.make(mlayout,"这里还在开发中,请前往右上角查看", Snackbar.LENGTH_LONG)

								.setAction("知道了", new View.OnClickListener(){@Override
									public void onClick(View view)
									{}}).show();
							break;
						case R.id.nav_sub2:
							mlayout=(CoordinatorLayout) findViewById(R.id.mainCoordinatorLayout1);
							Snackbar.make(mlayout,"这里还在开发中,请前往右上角查看", Snackbar.LENGTH_LONG)

								.setAction("知道了", new View.OnClickListener(){@Override
									public void onClick(View view)
									{}}).show();
							break;
					}
					menuItem.setChecked(false);//点击了把它设为选中状态
					mDrawerLayout.closeDrawers();//关闭抽屉
					return true;
				}
			});
		
		
		}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
		PgyFeedbackShakeManager.setShakingThreshold(1000);

		// 以对话框的形式弹出，对话框只支持竖屏
		PgyFeedbackShakeManager.register(MainActivity.this);

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
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.uyt)
		{
            Intent ytr=new Intent(this,AboutActivity.class);
			startActivity(ytr);
        }
		else{finish();}

        return super.onOptionsItemSelected(item);
    }
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
			if((System.currentTimeMillis()-exitTime) > 2000){  
				mlayout=(CoordinatorLayout) findViewById(R.id.mainCoordinatorLayout1);
				Snackbar.make(mlayout,"再按一次退出", Snackbar.LENGTH_LONG)
				.setAction("action",null).show();
				exitTime = System.currentTimeMillis();   
			} else {
				finish();
				System.exit(0);
			}
			return true;   
		}
		return super.onKeyDown(keyCode, event);
	}
			
    
	
	public void talkk(View view)
	{
		Intent ert=new Intent(this,TalkActivity.class);
		startActivity(ert);
	}
    public void ssea(View view)
	{
		Intent iuy=new Intent(this,SeaActivity.class);
		startActivity(iuy);
	}
	public void ssuan(View view)
	{
		Intent uut=new Intent(this,SuanActivity.class);
		startActivity(uut);
	}
	public void fanyi(View view)
	{
		Intent iop=new Intent(this,FanyiActivity.class);
		startActivity(iop);
	}
	}


	
    
