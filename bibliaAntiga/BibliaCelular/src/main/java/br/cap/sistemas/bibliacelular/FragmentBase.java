package br.cap.sistemas.bibliacelular;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class FragmentBase extends Fragment {

	private final String TAG = this.getClass().getName();
	private static final boolean LOG_ON = true;
	public static String AppName, PackageName, VersionCode, VersionName, AnoBase="2017";

	public static final Locale brasil = new Locale("pt","BR");

	public static NumberFormat nf = NumberFormat.getCurrencyInstance(brasil);

	private FragmentManager fragmentManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		fragmentManager = getActivity().getSupportFragmentManager();

		this.packinfo();
	}

	private void packinfo() {

		PackageInfo pinfo = null;

		try {
			pinfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
		} catch (PackageManager.NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AppName = pinfo.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
		PackageName = pinfo.packageName;
		VersionCode = String.valueOf(pinfo.versionCode);
		VersionName = pinfo.versionName;

	}


	protected void log(final String msg) {
		if(LOG_ON) {
			Log.d(TAG, msg);
		}
	}

	protected void alert(final String msg) {
		FragmentActivity activity = getActivity();
		if(activity != null) {
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					AlertDialog a = new AlertDialog.Builder(getContext()).setMessage(msg).setPositiveButton("OK", null).show();
					a.show();
				}
			});
		}
	}
	
	protected void toast(final String msg) {
		FragmentActivity activity = getActivity();
		if(activity != null) {
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	protected void enterFromBottomAnimation(){
		getActivity().overridePendingTransition(R.anim.activity_open_translate_from_bottom, R.anim.activity_no_animation);
	}

	protected void exitToBottomAnimation(){
		getActivity().overridePendingTransition(R.anim.activity_no_animation, R.anim.activity_close_translate_to_bottom);
	}


	public Context getContext() {
		return getActivity();
	}

	protected void show(Class<? extends Activity> cls) {
		startActivity(new Intent(getActivity(), cls));
	}
	
	protected void showRoot(Class<? extends Activity> cls) {
		Intent intent = new Intent(getActivity(), cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	protected void show(Class<? extends Activity> cls, Bundle bundle) {
		Intent intent = new Intent(getActivity(), cls);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	protected String getTextString(int id) {
		TextView t = (TextView) findViewById(id);
		return t != null ? t.getText().toString() : null;
	}
	
	protected void setText(int id, String s) {
		TextView t = (TextView) findViewById(id);
		if(t != null) {
			t.setText(s);
		}
	}

	protected void runOnUiThread(Runnable runnable) {
		getActivity().runOnUiThread(runnable);
	}

	private View findViewById(int id) {
		View view = getView();
		return view != null ? view.findViewById(id) : null;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	//getActivity().finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	protected ActionBar getSupportActionBar() {
		return getActivity().getActionBar();
	}
	protected MenuInflater getSupportMenuInflater() {
		return getActivity().getMenuInflater();
	}

	public final void replaceFragment(Fragment fragment) {
		if (fragment != null) {
			String tag = fragment.getTag() != null && !fragment.getTag().isEmpty() ? fragment.getTag() : fragment.getClass().getSimpleName();
			fragmentManager
					.beginTransaction()
					.replace(R.id.content_frame, fragment, tag)
					.commit();
		}
	}

}
