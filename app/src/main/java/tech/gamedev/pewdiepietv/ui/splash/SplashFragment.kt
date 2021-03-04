package tech.gamedev.pewdiepietv.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.gamedev.pewdiepietv.R
import tech.gamedev.pewdiepietv.databinding.FragmentSplashBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        slideUpAnimation()
        navigateToHome()
    }

    private fun slideUpAnimation() {

        val anim : Animation = AnimationUtils.loadAnimation(requireContext(),R.anim.slide_up_anim)
        binding.ivLogo.startAnimation(anim)
        binding.tvSplashTitle.startAnimation(anim)
        binding.loading.startAnimation(anim)


    }

    private fun navigateToHome() = lifecycleScope.launch {
        delay(4000)
        findNavController().navigate(R.id.action_splashFragment_to_navigation_home)
    }
}