package tech.gamedev.pewdiepietv.ui.merch

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_merch.*
import tech.gamedev.pewdiepietv.R
import tech.gamedev.pewdiepietv.databinding.FragmentMerchBinding
import tech.gamedev.pewdiepietv.ui.other.Constants.MERCH_STORE_URL

class MerchFragment : Fragment(R.layout.fragment_merch) {

    lateinit var binding: FragmentMerchBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMerchBinding.bind(view)
        setupWebView()
    }

            @SuppressLint("SetJavaScriptEnabled")
            private fun setupWebView() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.apply {
            loadUrl(MERCH_STORE_URL)
            settings.javaScriptEnabled = true
            settings.forceDark = WebSettings.FORCE_DARK_ON
            settings.allowContentAccess = true
            settings.supportZoom()
            setBackgroundColor(Color.parseColor("#ef3340"));


        }

    }


}