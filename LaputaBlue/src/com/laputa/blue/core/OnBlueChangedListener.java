package com.laputa.blue.core;

public interface OnBlueChangedListener {
	void onServiceDiscovered(String address);
	void onCharacteristicChanged(String address,byte[] value);
}
