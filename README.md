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

		<your viewpager.../>

</me.crosswall.lib.coverflow.core.PagerContainer>
```

#### two viewpagers synchronized scrolling.
```layout
<rootLayout....
 <me.crosswall.lib.coverflow.core.LinkagePagerContainer
        android:id="@+id/pager_container"
        android:layout_width="match_parent"
        android:layout_height="180dp">
        <android.support.v4.view.LinkagePager
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:layout_gravity="center"/>
  </me.crosswall.lib.coverflow.core.LinkagePagerContainer>
  <android.support.v4.view.LinkagePager
        android:id="@+id/pager"
        android:layout_gravity="center"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:velocity="150"/>

</rootLayout>
```
```java
LinkagePager aPager = (LinkagePager)findViewById(R.id.pager_a)

LinkagePager bPager = (LinkagePager)findViewById(R.id.pager_b)

aPager.setLinkagePager(bPager);

bPager.setLinkagePager(aPager);
```



