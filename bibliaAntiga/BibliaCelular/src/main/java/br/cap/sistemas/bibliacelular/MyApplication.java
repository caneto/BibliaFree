package br.cap.sistemas.bibliacelular;

import android.content.Context;
import android.os.StrictMode;

import androidx.multidex.MultiDexApplication;
import androidx.room.Room;

import com.splunk.mint.Mint;

import br.cap.sistemas.bibliacelular.db.AppDatabase;

public class MyApplication extends MultiDexApplication {

	public static Context CONTEXT;

	public static Context getContext() {
		return CONTEXT;
	}

	public MyApplication() {
		super();
	}

	public static AppDatabase database;

	@Override
	public void onCreate() {
	  super.onCreate();

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		if(CONTEXT == null){
			CONTEXT = getApplicationContext();
		}

		Mint.initAndStartSession(this, "64865785");
		//Mint.initAndStartSession(this, "40415a78");


		// Setup amd Config database Room - modec
		database = Room.databaseBuilder(this, AppDatabase.class, "modec-data").allowMainThreadQueries().build();

	}
}
