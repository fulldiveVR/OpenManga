# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

-keep class kotlin.reflect.jvm.internal.ReflectionFactoryImpl { *; }
# gson
-keepattributes *Annotation*

-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# fix
-keep class android.** { *; }
-keep class androidx.** { *; }
-keep class com.google.** { *; }
-keep class kotlinx.coroutines.** { *; }
-keep class okhttp3.** { *; }
-keep class kotlin.** { *; }
-keep class com.nostra13.universalimageloader.** { *; }
-keep class com.davemorrissey.labs.** { *; }
-keep class org.jsoup.** { *; }
-keep class com.soundcloud.android.** { *; }
-keep class com.getkeepsafe.taptargetview.** { *; }
-keep class info.guardianproject.** { *; }

#-keep class org.nv95.openmanga.** { *; }
-keep class org.nv95.openmanga.providers.** { *; }
-keep class org.nv95.openmanga.components.** { *; }
-keep class org.nv95.openmanga.core.** { *; }
-keep class org.nv95.openmanga.di.** { *; }
-keep class org.nv95.openmanga.dialogs.** { *; }
-keep class org.nv95.openmanga.feature.** { *; }
-keep class org.nv95.openmanga.helpers.** { *; }
-keep class org.nv95.openmanga.services.** { *; }

-keep @JvmOverloads class * {
  <init>(...);
  *;
}

# [custom rules begin]
-verbose
-renamesourcefileattribute SourceFile

-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod,AnnotationDefault,JavascriptInterface
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.content.Context {
   public void *(android.view.View);
   public void *(android.view.MenuItem);
}

-keep class com.google.** { *; }
-dontwarn com.google.**
-dontwarn com.squareup.picasso.**
-dontwarn com.viewpagerindicator.**

-keepclasseswithmembernames class * {
  native <methods>;
}

# Parcelable implementations are accessed by introspection
-keepclassmembers class * implements android.os.Parcelable {*;}
-keep class * implements android.os.Parcelable {*;}
-keepnames class * implements android.os.Parcelable {*;}

-keep @JvmOverloads class * {
  <init>(...);
  *;
}

# [custom rules end]
