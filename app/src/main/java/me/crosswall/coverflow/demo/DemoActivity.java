package me.crosswall.coverflow.demo;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by yuweichen on 16/4/30.
 */
public class DemoActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.demo_list);


        PreferenceManager manager = getPreferenceManager();

        Preference nomarl = manager.findPreference("normal");

        Preference transformer = manager.findPreference("normal2");

        Preference transformer2 = manager.findPreference("normal3");

        Preference overlap = manager.findPreference("overlap");

        Preference linkage0 = manager.findPreference("linkage0");

        Preference linkage1 = manager.findPreference("linkage1");

        Preference linkage2 = manager.findPreference("linkage2");

        nomarl.setOnPreferenceClickListener(this);

        transformer.setOnPreferenceClickListener(this);

        transformer2.setOnPreferenceClickListener(this);

        overlap.setOnPreferenceClickListener(this);

        linkage0.setOnPreferenceClickListener(this);

        linkage1.setOnPreferenceClickListener(this);

        linkage2.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {

        String key = preference.getKey();
        Intent intent = new Intent();
        switch (key){
            case "normal":
                intent.setClass(DemoActivity.this,NormalActivity.class);

                break;
            case "normal2":
                intent.setClass(DemoActivity.this,NormalActivity.class);
                intent.putExtra("showTransformer",true);
                break;
            case "normal3":
                intent.setClass(DemoActivity.this,Normal2Activity.class);
                intent.putExtra("showTransformer",true);
                break;
            case "overlap":
                intent.setClass(DemoActivity.this, OverlapActivity.class);
                break;
            case "linkage0":
                intent.setClass(DemoActivity.this,Linkage0PagerActivity.class);
                break;
            case "linkage1":
                intent.setClass(DemoActivity.this,LinkagePagerActivity.class);
                intent.putExtra("showRotate",true);
                break;
            case "linkage2":
                intent.setClass(DemoActivity.this,LinkagePager2Activity.class);
                break;

        }

        startActivity(intent);
        return false;
    }
}
