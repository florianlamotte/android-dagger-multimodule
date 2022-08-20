package com.nurokron.android.daggermultimodule

import android.app.Application
import com.nurokron.android.daggermultimodule.di.DaggerApplicationComponent

class DaggerMultiModuleApplication : Application() {
    val applicationDaggerComponent = DaggerApplicationComponent.create()
}