package br.cap.sistemas.bibliacelular;

import android.content.Context;
import androidx.multidex.MultiDexApplication;

import com.splunk.mint.Mint;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import io.realm.Realm;
import io.realm.RealmConfiguration;

@ReportsCrashes(formKey = "", // will not be used
mailTo = "xxxxx@gmail.com",
customReportContent = { ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT },
mode = ReportingInteractionMode.TOAST,
resToastText = R.string.crash_toast_text
)

 public class MyApplication extends MultiDexApplication {

	public static Context CONTEXT;

	public static Context getContext() {
		return CONTEXT;
	}

	public MyApplication() {
		super();
	}

	@Override
	public void onCreate() {
	  super.onCreate();

		if(CONTEXT == null){
			CONTEXT = getApplicationContext();
		}

		Mint.initAndStartSession(this, "64865785");
		//Mint.initAndStartSession(this, "40415a78");

		// The following line triggers the initialization of ACRA
		ACRA.init(this);

		// Setup Realm database
		Realm.init( this);

		RealmConfiguration config = new RealmConfiguration.Builder()
				.name("biblia-data.realm")
				.schemaVersion(1)
				// .migration(new MyMigration())
				.build();

		// Use the config
		Realm realm = Realm.getInstance(config);

	}
}
