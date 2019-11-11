package com.facebook.react;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by luoxudong on 2018/7/2.
 */

public class MOReactActivityDelegate extends ReactActivityDelegate {
    private Activity mActivity = null;

    public MOReactActivityDelegate(Activity activity, @Nullable String mainComponentName) {
        super(activity, mainComponentName);
        mActivity = activity;
    }

    public MOReactActivityDelegate(FragmentActivity fragmentActivity, @Nullable String mainComponentName) {
        super(fragmentActivity, mainComponentName);
        mActivity = fragmentActivity;
    }

    @Override
    protected ReactNativeHost getReactNativeHost() {
        return new ReactNativeHost(mActivity.getApplication()) {

            @Override
            public boolean getUseDeveloperSupport() {
                return BuildConfig.DEBUG;
            }

            @Override
            protected List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                        new MainReactPackage()
                );
            }

            @Nullable
            @Override
            protected String getBundleAssetName() {
                return "index.android.bundle";
            }

            @Override
            protected String getJSMainModuleName() {
                return "index";
            }

            @Nullable
            @Override
            protected String getJSBundleFile() {
                return null;
            }
        };
    }
}
