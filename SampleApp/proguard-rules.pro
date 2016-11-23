# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /data/Development/Android/android-sdk-linux/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep class android.support.** { *; }
-keep interface android.support.** { *; }

-keep class com.paypal.android.** { *; }
-keep interface com.paypal.android.** { *; }

-keep class com.google.android.gms.** { *; }
-keep interface com.google.android.gms.** { *; }

-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }

-keepclassmembers class * implements javax.net.ssl.SSLSocketFactory {
         private javax.net.ssl.SSLSocketFactory delegate;
    }

-dontwarn com.squareup.picasso.**
-dontwarn com.paypal.android.**
-dontwarn okio.**