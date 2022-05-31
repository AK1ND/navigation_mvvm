package com.alex_kind.navigation_mvvm.screens.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex_kind.navigation_mvvm.databinding.FragmentHelloBinding
import com.alex_kind.navigation_mvvm.screens.base.BaseFragment
import com.alex_kind.navigation_mvvm.screens.base.BaseScreen
import com.alex_kind.navigation_mvvm.screens.base.screenViewModel

class HelloFragment : BaseFragment() {

    class Screen: BaseScreen

    override val viewModel by screenViewModel<HelloViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHelloBinding.inflate(inflater, container, false)

        binding.editButton.setOnClickListener {
            viewModel.onEditPressed()
        }

        viewModel.currentMessageLiveData.observe(viewLifecycleOwner) {
            binding.valueTextView.text = it
        }

        return binding.root
    }

}