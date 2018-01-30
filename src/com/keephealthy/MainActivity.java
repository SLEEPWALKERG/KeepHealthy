package com.keephealthy;

import com.keephealthy.ChartActivity;
import com.keephealthy.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
	//变量
	private EditText searchContent;
	private ImageButton btnSearch;
	private TextView btnHospital;
	private TextView btnCalendar;
	private TextView btnChart;
	private TextView btnExercise;
	
	private TextView btnBackToMainActivity;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//查找问题
		//initSearch();
		//附近医院模块
		searchNearHospital();
		//健康日历
		openCalendar();
		//健康折线
		openChart();
		
		
		
		
	}
	/**
	 * 健康折线
	 */
	private void openChart() {
		// TODO 自动生成的方法存根
		btnChart=(TextView) findViewById(R.id.btnChart);
		btnChart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,ChartActivity.class));
				
			}
		});
		
	}
	/**
	 * 健康日历模块
	 */
	private void openCalendar() {
		// TODO 自动生成的方法存根
		btnCalendar=(TextView) findViewById(R.id.btnCalendar);
		btnCalendar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				startActivity(new Intent(MainActivity.this,CalendarActivity.class));
				
			}
		});
		
		
	}

	/**
	 * 附近医院吗
	 */
	private void searchNearHospital() {
		// 给附近医院图标设置监听
		btnHospital=(TextView) findViewById(R.id.btnHospital);
		btnHospital.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//点击触发操作。进入网页百度地图 后期改为api
				Uri uri = Uri.parse("https://map.baidu.com/mobile/webapp/search/search/qt=s&wd=医院&c=289&searchFlag=bigBox&version=5&exptype=dep&src_from=webapp_all_bigbox&src=0&nb_x=13515414.57&nb_y=3640944.02&center_rank=1/vt=map"); 
				Intent it   = new Intent(Intent.ACTION_VIEW,uri); 
				startActivity(it); 
				
				
			}
		});
	}
	
	/**
	 * 查找问题
	 */
 
	private void initSearch() {
		// 设置监听
		btnSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 点击search图标后触发智能回答
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.btnMenuAbout:
			//toast版
			//Toast.makeText(MainActivity.this, "超级无敌炫酷的小组，成员有顾瓜皮，彭思，焦鹏昆。", Toast.LENGTH_LONG).show();
			//break;
			//default:
			//	break;
			 AlertDialog.Builder builder = new AlertDialog.Builder(this);
			 builder.setTitle("制作团队信息");
			 builder.setMessage("华东师范大学\n指导老师: 杨燕\n成员:\n计算机科学与技术17级焦鹏昆\n计算机科学与技术17级顾铭\n环境科学16年级彭思");
			 builder.setPositiveButton("确定", null);
			 AlertDialog alertDialog = builder.create(); 
			 // 显示对话框
			 alertDialog.show();  

		}
		return super.onOptionsItemSelected(item);
	}
}
