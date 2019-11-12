package com.kreactive.enceintekotlin

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.database.FirebaseDatabase
import com.kreactive.data.repository.FirebaseDataRepository
import com.kreactive.domain.info.repository.FirebaseRepository
import io.fabric.sdk.android.Fabric

private const val TAG = "BaseApplication"

class BaseApplication : Application() {

    val firebaseRepository: FirebaseRepository by lazy { FirebaseDataRepository() }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
    }

}