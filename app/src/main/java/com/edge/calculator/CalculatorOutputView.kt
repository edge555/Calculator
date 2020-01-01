package com.edge.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout

class CalculatorOutputView (context: Context,attributeSet: AttributeSet?) : LinearLayout(context,attributeSet){
    init{
        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        LayoutInflater.from(context).inflate(R.layout.view_output,this,true)
        //addView(view);
    }
}