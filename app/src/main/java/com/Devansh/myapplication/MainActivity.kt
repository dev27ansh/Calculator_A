package com.Devansh.myapplication

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.Devansh.myapplication.ui.theme.EasyCalculatorTheme
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : ComponentActivity() {

    lateinit var button1 : android.widget.Button
    lateinit var button2 : android.widget.Button
    lateinit var button3 : android.widget.Button
    lateinit var button4 : android.widget.Button
    lateinit var button5 : android.widget.Button
    lateinit var button6 : android.widget.Button
    lateinit var button7 : android.widget.Button
    lateinit var button8 : android.widget.Button
    lateinit var button9 : android.widget.Button
    lateinit var button0 : android.widget.Button
    lateinit var button00 : android.widget.Button
    lateinit var buttonpercent : android.widget.Button
    lateinit var buttonclear: Button
    lateinit var buttondot : Button
    lateinit var buttonequal : Button
    lateinit var buttonadd : Button
    lateinit var buttonsubtract : Button
    lateinit var buttonmultiply : Button
    lateinit var buttondivide : Button
    lateinit var buttonbackspace : Button
    lateinit var inputtex : EditText
    lateinit var resulttex : EditText
    var check = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        


        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button00=findViewById(R.id.button00);
        buttonpercent=findViewById(R.id.buttonpercent);
        buttonclear=findViewById(R.id.clear);
        buttondot=findViewById(R.id.buttondot);
        buttonequal=findViewById(R.id.buttonequal);
        buttonadd=findViewById(R.id.buttonadd);
        buttonsubtract=findViewById(R.id.buttonsubtract);
        buttonmultiply=findViewById(R.id.buttonmultiply);
        buttondivide=findViewById(R.id.buttondivide);
        buttonbackspace=findViewById(R.id.buttonbackspace);
        resulttex=findViewById(R.id.result);
        inputtex=findViewById(R.id.inputnumber);

        inputtex.setActivated(true)
        inputtex.setPressed(true)

        var text:String

        button1.setOnClickListener {
            text=inputtex.text.toString()+"1"
            inputtex.setText(text)
            result(text)

        }
        button2.setOnClickListener {
            text=inputtex.text.toString()+"2"
            inputtex.setText(text)
            result(text)

        }
        button3.setOnClickListener {
            text=inputtex.text.toString()+"3"
            inputtex.setText(text)
            result(text)

        }

        button4.setOnClickListener {
            text=inputtex.text.toString()+"4"
            inputtex.setText(text)
            result(text)

        }

        button5.setOnClickListener {
            text=inputtex.text.toString()+"5"
            inputtex.setText(text)
            result(text)

        }

        button6.setOnClickListener {
            text=inputtex.text.toString()+"6"
            inputtex.setText(text)
            result(text)

        }

        button7.setOnClickListener {
            text=inputtex.text.toString()+"7"
            inputtex.setText(text)
            result(text)

        }

        button8.setOnClickListener {
            text=inputtex.text.toString()+"8"
            inputtex.setText(text)
            result(text)

        }

        button9.setOnClickListener {
            text=inputtex.text.toString()+"9"
            inputtex.setText(text)
            result(text)

        }

        button0.setOnClickListener {
            text=inputtex.text.toString()+"0"
            inputtex.setText(text)
            result(text)

        }

        button00.setOnClickListener {
            text=inputtex.text.toString()+"00"
            inputtex.setText(text)
            result(text)

        }

        buttondot.setOnClickListener {
            text=inputtex.text.toString()+"."
            inputtex.setText(text)
            result(text)

        }

        buttonadd.setOnClickListener {
            text=inputtex.text.toString()+"+"
            inputtex.setText(text)
            check=check+1

        }

        buttondivide.setOnClickListener {
            text = inputtex.text.toString() + "/"
            inputtex.setText(text)
            check = check + 1
        }

        buttonmultiply.setOnClickListener {
            text = inputtex.text.toString() + "*"
            inputtex.setText(text)
            check = check + 1
        }

        buttonsubtract.setOnClickListener {
            text = inputtex.text.toString() + "-"
            inputtex.setText(text)
            check = check + 1
        }


        buttonpercent.setOnClickListener {
            text = inputtex.text.toString() + "%"
            inputtex.setText(text)
            check = check + 1
        }

        buttonadd.setOnClickListener {
            text = resulttex.text.toString() + "+"
            inputtex.setText(text)
            resulttex.setText(null)
        }

        buttonclear.setOnClickListener {
            inputtex.setText(null)
            resulttex.setText(null)
        }
        buttonbackspace.setOnClickListener {

            var Backspace: String?=null
            if(inputtex.text.length>0)
            {
                val stringBuilder: StringBuilder =StringBuilder(inputtex.text)
                val find=inputtex.text.toString()
                val find2=find.last()

                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%'))
                {
                    check=check-1
                }

                stringBuilder.deleteCharAt(inputtex.text.length-1)
                Backspace=stringBuilder.toString()
                inputtex.setText(Backspace)
                result(Backspace)
            }
        }






    }

    private fun result(text: String) {

        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")

        try {
            val result: Any =engine.eval (text)
            var mainr=result.toString()


            if (check == 0) {



                resulttex.setText(null)
            }  else {

                resulttex.setText(mainr)


            }
        }  catch (e: ScriptException){
            Log.d("TAG","ERROR")
        }

    }
}