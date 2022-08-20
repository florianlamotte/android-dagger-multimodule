package com.nurokron.android.daggermultimodule.di

import com.nurokron.android.daggermultimodule.MainActivity
import dagger.Component

@Component
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}