package com.uma.creditscoreui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uma.creditscoreui.widgets.CircleAngleAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateScreen()
        addText()
    }

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun addText(){
        val number = "12349512"
        val mask = number.replace(
            "\\w(?=\\w{4})".toRegex(),
            resources.getString(R.string.text_with_bullet)
        )
        txt_bank_acno.text = mask

        txt_pay_amount.text = spanText(resources.getString(R.string.rupee) + "34000",0,1,0.5f)

        txt_total_due_amount.text = spanText(resources.getString(R.string.rupee) + " " + "34000",0,1,0.5f)

        txt_payment.text = spanText("Pay "+resources.getString(R.string.rupee) + " " + "34000",4,5,0.8f)

        val date: String = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())

        try {
            val inputFormat = SimpleDateFormat("MM/dd/yy")
            val parsedDate = inputFormat.parse(date)
            val outputFormat = SimpleDateFormat("dd MMM yy")
           val inputDate = outputFormat.format(parsedDate)

            txt_date.text = inputDate
        } catch (e: Exception) {
            e.printStackTrace()
        }

        Glide.with(this)
            .load("https://res.cloudinary.com/www-acsz-in/image/upload/v1611990517/Wizi%20V2/Bank%20Short%20Logo/hdfc_hadbww.png")
            .into(img_bank_logo)
    }

    private fun spanText(amount: String,start : Int,end: Int,portion : Float) : SpannableString{
        val totalAmount = SpannableString(amount)
        totalAmount.setSpan(RelativeSizeSpan(portion), start, end, 0) // set size
        return totalAmount
    }

    private fun updateScreen() {
        val animation = CircleAngleAnimation(
            score_circle_animation, (180 * (100 - 0)
                    / (100))
        )
        animation.duration = 3000
        score_circle_animation.startAnimation(animation)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_back ->{}
            btn_custom ->{}
            btn_minimum ->{}
            btn_total -> {}
            btn_payment  -> {}
        }
    }
}