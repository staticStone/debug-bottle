@file:Suppress("unused")

package com.exyui.android.debugbottle.components.injector

import android.app.Activity
import android.content.Intent
import com.exyui.android.debugbottle.components.DTActivityManager

/**
 * Created by yuriel on 8/15/16.
 */
abstract class Injector {
    private val intentInjector = IntentInjector
    private val runnableInjector = RunnableInjector
    private val quickEntry = QuickEntry

    protected val activity: Activity?
        get() = DTActivityManager.topActivity

    protected fun put(intent: Intent, name: String = intent.toString()) {
        intentInjector.put(name, intent)
    }

    protected fun put(runnable: Runnable, name: String = runnable.toString()) {
        runnableInjector.put(name, runnable)
    }

    protected fun quickEntry(at: Class<out Activity>, name: String, t: Runnable) {
        quickEntry.put(at, name, t)
    }

    protected fun quickEntry(name: String, listener: QuickEntry.OnActivityDisplayedListener) {
        quickEntry.put(name, listener)
    }

    abstract fun inject()
}