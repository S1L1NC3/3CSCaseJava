package com.dmd.a3cscasejava.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmd.a3cscasejava.R
import com.dmd.a3cscasejava.databinding.ActivityMainBinding
import com.dmd.a3cscasejava.view.MainFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_activity) disabled cause of binding

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