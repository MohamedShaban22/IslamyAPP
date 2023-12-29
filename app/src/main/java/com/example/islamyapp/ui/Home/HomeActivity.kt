package com.example.islamyapp.ui.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamyapp.R
import com.example.islamyapp.databinding.ActivityHomeBinding
import com.example.islamyapp.databinding.FragmentSebhaBinding
import com.example.islamyapp.ui.Home.Hadeth.HadethFragment
import com.example.islamyapp.ui.Home.Quran.QuranFragment
import com.example.islamyapp.ui.Home.Radio.RadioFragment
import com.example.islamyapp.ui.Home.Sebha.SebhaFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        pushFragment(QuranFragment())
        viewBinding.contentLayout
            .botNavBar.setOnItemSelectedListener(
                object :NavigationBarView.OnItemSelectedListener{
                    override fun onNavigationItemSelected(item: MenuItem): Boolean {

                        when(item.itemId){
                            R.id.navQuran ->{pushFragment(QuranFragment())}
                            R.id.navHadeth->{pushFragment(HadethFragment())}
                            R.id.navSebha->{pushFragment(SebhaFragment())}
                            R.id.navRadio->{pushFragment(RadioFragment())}
                        }
                        return true
                    }


                }
            )
    }
    fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}