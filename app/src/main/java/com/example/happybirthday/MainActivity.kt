package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button=findViewById(R.id.button)
        //val diceImage: ImageView = findViewById(R.id.imageView)

        rollButton.setOnClickListener {
           // Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
             val ans=rolldice()
            if(ans==6)
                Toast.makeText(this, "sahi hai beta", Toast.LENGTH_SHORT).show()


        }
    }

    private fun rolldice():Int {

        val num=dice(6)
        val result=num.roll()
        val dicetext: TextView =findViewById(R.id.textView)

        dicetext.text= result.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when(result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5

            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        return result


    }


}

class dice(val setFace: Int)
{
    fun roll():Int
    {
        val result=(1..6).random()
        return result;
    }
}
