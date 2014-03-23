package com.example.mobileappsample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	WebView mWeb = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		mWeb = (WebView) this.findViewById(R.id.mainWebView);
		mWeb.setWebViewClient(new WebViewClient());

		WebSettings set = mWeb.getSettings();
		set.setJavaScriptEnabled(true);
		set.setBuiltInZoomControls(true);

		mWeb.loadUrl("http://www.naver.com");
		final EditText addr = (EditText) this.findViewById(R.id.etn1);
		Button btn = (Button) this.findViewById(R.id.Button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = addr.getText().toString();
				mWeb.loadUrl(url);
			}
		});
		Button btn2 = (Button) this.findViewById(R.id.Button2);
		//btn2.setOnClickListener(this);
		Button btn3 = (Button) this.findViewById(R.id.Button3);
		//btn3.setOnClickListener(this);
		Button btn4 = (Button) this.findViewById(R.id.Button4);
		//btn4.setOnClickListener(this);
		Button btn5 = (Button) this.findViewById(R.id.Button5);
		//btn5.setOnClickListener(this);
		
		/*
		WebView mainWebView = (WebView) findViewById(R.id.mainWebView);
		
		WebSettings webSettings = mainWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		mainWebView.setWebViewClient(new MyCustomWebViewClient());
		mainWebView.loadUrl("http://sokoban.co.kr");
		*/
	}

	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText addr = (EditText) this.findViewById(R.id.etn1);
		switch (arg0.getId()) {
		case R.id.Button1: // 사용자가 원하는 사이트가기
			String url = addr.getText().toString();
			mWeb.loadUrl(url);
			break;
		case R.id.Button2: // 뒤로가기
			mWeb.goBack();
			break;
		case R.id.Button3: // 앞으로가기
			if (mWeb.canGoForward()) {
				mWeb.goForward();
			}
			break;
		case R.id.Button4:
			mWeb.loadUrl("file:///android_asset/test.html");
			break;
		case R.id.Button5:
			mWeb.loadUrl("http://www.google.com");
			break;
		}
	}
	
	private class MyCustomWebViewClient extends WebViewClient{

		public boolean shuouldOverrideUrlLoading(WebView view, String url){
			view.loadUrl(url);
			return true;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
