package newsproject.newstime

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import zerobranch.androidremotedebugger.AndroidRemoteDebugger

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidRemoteDebugger.init(applicationContext)
    }
}