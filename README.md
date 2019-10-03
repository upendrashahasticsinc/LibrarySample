# LibrarySample

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
	
	implementation 'com.github.upendrashahasticsinc:LibrarySample:0.0.3'

uses 

	<com.astics.mylibrary.UsTextView
            android:id="@+id/txvNotification"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:gravity="center"
            android:padding="5dp"
            android:text="@string/txt_notification"
            app:custom_input_type="capsWord"
            app:custom_typeface="montserrat_regular" />
