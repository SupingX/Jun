package com.laputa.blue;

import com.laputa.blue.util.XLog;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class BaseApp extends Application {
	private SimpleBlueService simpleBlueService;
	public SimpleBlueService getSimpleBlueService(){
		return this.simpleBlueService;
	}
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			SimpleBlueService.MyBinder binder = (SimpleBlueService.MyBinder )service;
			simpleBlueService = binder.getSimpleBlueService();
			XLog.e("BaseApp", "application获取服务 ："+ simpleBlueService);
		}
	};
	

	@Override
	public void onCreate() {
		super.onCreate();
		Intent intent = new Intent(this,SimpleBlueService.class);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
		
		
	}


	@Override
	public void onTerminate() {
		super.onTerminate();
		if(simpleBlueService != null){
			
		}
		unbindService(conn);
	}
	
	
	
}
