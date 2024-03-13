#include <jni.h>
#include <string>
#include "Calculator.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jni_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jni_NativeLib_Add(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return Add(num1, num2);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jni_NativeLib_Subtract(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return Subtract(num1,num2);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jni_NativeLib_Multiply(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return Multiply(num1,num2);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jni_NativeLib_Divide(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return Divide(num1,num2);
}