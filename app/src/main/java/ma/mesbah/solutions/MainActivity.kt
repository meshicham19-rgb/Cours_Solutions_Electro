package ma.mesbah.solutions

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Cours interactif : Concentration et solutions électrolytiques (1 Bac SE)
 * Pr Hicham MESBAH — Docteur en Électronique, traitement du signal et contrôle non destructif
 */
class MainActivity : Activity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web = WebView(this).apply {
            setBackgroundColor(Color.parseColor("#0B0920"))
            settings.javaScriptEnabled = true      // simulations, quiz, cartes « Révéler »
            settings.domStorageEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.builtInZoomControls = false
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
        }
        setContentView(web)

        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState)
        } else {
            web.loadUrl("file:///android_asset/index.html")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        web.saveState(outState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
