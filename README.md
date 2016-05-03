##Android-CoverFlow

A beautiful cover flow for android platform , base on ViewPager.

###build
#####Step 1. Add the JitPack repository to your build file
```build
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
	
#####Step 2. Add the dependency
```build
dependencies {
	        compile 'com.github.crosswall:Android-Coverflow:release-v1.0.0'
	}
```

###layout.xml
```layout
<me.crosswall.lib.coverflow.core.PagerContainer
        android:id="@+id/pager_container"
        android:layout_width="match_parent"
        android:layout_height="220dp"
        android:background="?attr/colorPrimary">

        <android.support.v4.view.ViewPager
            android:layout_width="300dp"
            android:layout_height="200dp"
            android:layout_gravity="center" />


    </me.crosswall.lib.coverflow.core.PagerContainer	
```



