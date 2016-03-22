package com.laputa.blue.broadcast;

import java.util.ArrayList;
import java.util.List;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class LaputaBroadcast {
	public static final String ACTION_DEVICES_FOUND = "ACTION_DEVICES_FOUND";
	public static final String ACTION_DEVICE_FOUND = "ACTION_DEVICE_FOUND";
	public static final String ACTION_IS_SCANING = "ACTION_IS_SCANING";
	public static final String ACTION_STATE = "ACTION_STATE";
	
	
	
	public static final String EXTRA_DEVICES = "EXTRA_DEVICES";
	public static final String EXTRA_DEVICE = "EXTRA_DEVICE";
	public static final String EXTRA_SCANING = "EXTRA_SCANING";
	public static final String EXTRA_ADDRESS = "EXTRA_ADDRESS";
	public static final String EXTRA_STATE = "EXTRA_STATE";
	
	/*private static LaputaBroadcast lb;
	private LaputaBroadcast(){
		
	}
	public static LaputaBroadcast newInstance(){
		if (lb == null) {
			lb = new LaputaBroadcast();
		}
		return lb;
	}*/
	
	
	public static void sendBroadcastForDevicesFound(ArrayList<BluetoothDevice> devices,Context context){
		Intent intent = new Intent();
		intent.setAction(ACTION_DEVICES_FOUND);
		intent.putParcelableArrayListExtra(EXTRA_DEVICES, devices);
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcastForDeviceFound(BluetoothDevice device,Context context){
		Intent intent = new Intent();
		intent.setAction(ACTION_DEVICE_FOUND);
		intent.putExtra(EXTRA_DEVICE, device);
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcastForIsScanning(boolean scanning,Context context){
		Intent intent = new Intent();
		intent.setAction(ACTION_IS_SCANING);
		intent.putExtra(EXTRA_SCANING, scanning);
		context.sendBroadcast(intent);
	}
	
	public static void sendBroadcastForStateChanged(String address,int state,Context context){
		Intent intent = new Intent();
		intent.setAction(ACTION_STATE);
		intent.putExtra(EXTRA_ADDRESS, address);
		intent.putExtra(EXTRA_STATE, state);
		context.sendBroadcast(intent);
	}
	
	public static IntentFilter getIntentFilter(){
		IntentFilter filter = new IntentFilter();
		filter.addAction(ACTION_DEVICES_FOUND);
		filter.addAction(ACTION_DEVICE_FOUND);
		filter.addAction(ACTION_IS_SCANING);
		filter.addAction(ACTION_STATE);
		return filter;
	}

}
