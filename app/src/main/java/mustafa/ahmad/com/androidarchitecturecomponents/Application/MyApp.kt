package mustafa.ahmad.com.androidarchitecturecomponents.Application

import android.app.Application
import android.content.Context

// Not object class. AndroidManifest.xml error happen.
class MyApp : Application() {

    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        MyApp.context = applicationContext
    }

//    fun getAppContext(): Context {
//        Log.e("MyApplication", "_getAppContextInvoked")
//        return MyApp.context
//    }
}