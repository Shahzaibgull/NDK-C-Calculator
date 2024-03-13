package com.example.jni

class NativeLib {

    /**
     * A native method that is implemented by the 'jni' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun Add(num1:Int, num2:Int):Int
    external fun Subtract(num1:Int,num2:Int):Int
    external fun Multiply(num1:Int,num2:Int):Int
    external fun Divide(num1:Int,num2:Int):Int

    companion object {
        // Used to load the 'jni' library on application startup.
        init {
            System.loadLibrary("jni")
        }
    }
}