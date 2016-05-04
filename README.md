##Android-CoverFlow
A beautiful cover flow for android platform , base on ViewPager.

###[Demo Vedio](https://youtu.be/2FEp33kisz4)

##GIF
<img src="https://github.com/crosswall/Android-Coverflow/blob/master/gif/3.pic_hd.gif" width="40%" height="40%">


###Build
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
	compile 'com.github.crosswall:Android-Coverflow:release-v1.0.1'
}
```

###Layout.xml

```layout
<me.crosswall.lib.coverflow.core.PagerContainer
        android:id="@+id/pager_container"
        android:layout_width="match_parent"
        android:layout_height="220dp"
        android:background="?attr/colorPrimary">

		<your viewpager.../>

</me.crosswall.lib.coverflow.core.PagerContainer>
```
```java
 new CoverFlow.Builder()
             .with(viewpager)
             .pagerMargin(0f)
             .scale(0.3f)
             .spaceSize(0f)
             .rotationY(0f)
             .build();

```

#### Two viewpagers synchronized scrolling.
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
//init widget
LinkagePager aPager = (LinkagePager)findViewById(R.id.pager_a)
LinkagePager bPager = (LinkagePager)findViewById(R.id.pager_b)
//binding scroll
aPager.setLinkagePager(bPager);
bPager.setLinkagePager(aPager);
```

###TODO
>* HorizontalScrollView replace LinkagePager
>* More CoordinatorLayout.Behavior...
>* More Configurations...

###Lincense
```lincense
The MIT License (MIT)

Copyright (c) 2015 Hugo yu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Status API Training Shop Blog About Pricing
```
