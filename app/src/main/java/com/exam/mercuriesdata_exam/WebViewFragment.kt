package com.exam.mercuriesdata_exam

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.exam.mercuriesdata_exam.databinding.WebViewFragmentBinding

class WebViewFragment : Fragment(R.layout.web_view_fragment) {

    private val binding by viewBinding(WebViewFragmentBinding::bind)

    private val args by navArgs<WebViewFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(args.apodSite)
        }
    }
}