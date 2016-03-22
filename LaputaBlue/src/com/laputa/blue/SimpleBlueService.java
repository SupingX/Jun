package com.laputa.blue;

import com.laputa.blue.core.AbstractSimpleLaputaBlue;
import com.laputa.blue.core.Configration;
import com.laputa.blue.core.OnBlueChangedListener;
import com.laputa.blue.core.SimpleLaputaBlue;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SimpleBlueService extends Service{
	
	private AbstractSimpleLaputaBlue simpleLaputaBlue;
	
	public AbstractSimpleLaputaBlue getSimpleLaputaBlue(){
		return this.simpleLaputaBlue;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (simpleLaputaBlue != null) {
			simpleLaputaBlue.closeAll();
		}
	}
	@Override
	public void onCreate() {
		super.onCreate();
		
		simpleLaputaBlue = new SimpleLaputaBlue(this, new Configration(),new OnBlueChangedListener() {
			
			@Override
			public void onServiceDiscovered(String address) {
				
			}
			
			@Override
			public void onCharacteristicChanged(String address, byte[] value) {
				
			}
		});
		
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
		
	}
	
	public class MyBinder extends Binder {
		public SimpleBlueService getSimpleBlueService(){
			return SimpleBlueService.this;
		}
	}

}
