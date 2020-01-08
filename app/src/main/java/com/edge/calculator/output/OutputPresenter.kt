package com.edge.calculator.output

import bsh.Interpreter
import java.lang.Exception

object OutputPresenter {
    private var mnViews: OutputInterfaceView? = null
    private var mnCurretEquation : String = ""
    private var mnCurretOutcome : String = ""
    private var mnIntrepreter = Interpreter()

    fun attach(view : OutputInterfaceView){
        mnViews = view
        updateEquation()
        updateOutcome()
    }

    fun detach(){
        mnViews = null
    }

    fun add(item : String){
        mnCurretEquation = mnCurretEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun remove(){
        if(mnCurretEquation.length>1) {
            mnCurretEquation = mnCurretEquation.substring(0, mnCurretEquation.length - 1)
        }
        else{
            mnCurretEquation = ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun solve(){
        if(mnCurretOutcome.isNotEmpty()){
            mnCurretEquation = mnCurretOutcome
            mnCurretOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }

    fun clear(){
        mnCurretEquation = ""
        mnCurretOutcome = ""
        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome(){
        if(mnCurretEquation.isNotEmpty()){
            try{
                mnIntrepreter.eval("result = $mnCurretEquation")
                val result = mnIntrepreter.get("result")

                if(result != null && result is Int){
                    mnCurretOutcome = result.toString()
                }
            } catch (e : Exception){
                mnCurretOutcome = ""
            }
        }
        else{
            mnCurretOutcome = ""
        }
    }

    private fun updateEquation(){
        mnViews?.setequation(mnCurretEquation)
    }

    private fun updateOutcome(){
        mnViews?.setOutcome(mnCurretOutcome)
    }
}