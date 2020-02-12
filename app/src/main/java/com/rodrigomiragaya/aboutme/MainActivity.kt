package com.rodrigomiragaya.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil

import com.rodrigomiragaya.aboutme.databinding.MainNewBinding

/**
 *
 * Create and Save Style (MindBlowing)
 *
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainNewBinding

    private val myName : MyName = MyName("Rodrigo Miragaya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_new)
        binding = DataBindingUtil.setContentView(this, R.layout.main_new)
        binding.myName = myName

//        findViewById<Button>(R.id.doneBtn).setOnClickListener {
//            addNickName(it)
//        }
        binding.doneBtn.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view:View){

        binding.apply {
//            displayNickname.text = binding.nicknameEdit.text
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneBtn.visibility = View.GONE
            displayNickname.visibility = View.VISIBLE
        }


        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
