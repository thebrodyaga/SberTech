package com.sbertech;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                activityLifecycleLog(activity,"onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                activityLifecycleLog(activity,"onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                activityLifecycleLog(activity,"onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                activityLifecycleLog(activity,"onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                activityLifecycleLog(activity,"onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                activityLifecycleLog(activity,"onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityLifecycleLog(activity,"onActivityDestroyed");
            }
        });
    }

    private void activityLifecycleLog(Activity activity, String str) {
        Log.d("ActivityLifecycle", "Activity: " + activity.getClass().getSimpleName() +
                ", Id: " + System.identityHashCode(activity) +
                ", MethodName: " + str);
    }

}
