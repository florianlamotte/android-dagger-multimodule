package com.nurokron.android.useragedynamicmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nurokron.android.useragedynamicmodule.databinding.UserAgeNavigationFragmentBinding

class UserAgeNavigationFragment
    : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(
        ): UserAgeNavigationFragment {
            return UserAgeNavigationFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return UserAgeNavigationFragmentBinding.inflate(inflater, container, false).root
    }

}