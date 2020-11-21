package com.dmd.a3cscasejava.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmd.a3cscasejava.R
import com.dmd.a3cscasejava.databinding.ActivityMainBinding
import com.dmd.a3cscasejava.view.MainFragment

class MainActivity : AppCompatActivity() {
    companion object {
        var EXTRAS_KEY = "3SidedCubeExtrasKey"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}