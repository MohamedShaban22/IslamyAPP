package com.example.islamyapp.ui.Home.Quran

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentQuranBinding

lateinit var viewBinding:FragmentQuranBinding

class QuranFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var suraNameAdapter: SuraQuranAdapter
    lateinit var switchModeButton: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentQuranBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.sura_name_recyclerview)
        suraNameAdapter = SuraQuranAdapter(Constants.arSuras.mapIndexed { position, name ->
            SuraName(name, position + 1)
        })

        suraNameAdapter.onSuraItemClickListener = object : OnSuraItemClickListener {
            override fun onSuraClick(suraName: SuraName) {
                val intent = Intent(activity, SuraDetailsActivity::class.java)
                intent.putExtra("sura_name", suraName.name)
                intent.putExtra("sura_position", suraName.suraPosition)
                startActivity(intent)
            }
        }

        recyclerView.adapter = suraNameAdapter
        switchModeButton = view.findViewById(R.id.switch_mode_btn)
        sharedPreferences = requireContext().getSharedPreferences(
            Constants.islamySheredPrefrenses, Context.MODE_PRIVATE
        )

        // Set the initial button text based on the current mode
        updateButtonState()

        switchModeButton.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                putModeInSharedPrefrences(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                putModeInSharedPrefrences(AppCompatDelegate.MODE_NIGHT_NO)
            }

            // Update the button text after toggling the mode
            updateButtonState()
        }
    }

    private fun putModeInSharedPrefrences(mode: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(Constants.Islamy_Mode_Key, mode)
        editor.apply()
    }

    private fun updateButtonState() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            switchModeButton.text = "Dark Mode"
        } else {
            switchModeButton.text = "Light Mode"
        }
    }
}
