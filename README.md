# Android Boilerplate Starterapp
Android project folder initialised with some basic settings and sdks

### Summary
- MVP
- Kotlin

### SDKs:
- Stetho: Debug your app using Google Chrome https://github.com/facebook/stetho
- Butterknife: Bind views easily using annotations https://github.com/JakeWharton/butterknife (Disabled by default since we have kotlin now)
- Lombok: Easily add Getter and Setter using annotations https://github.com/rzwitserloot/lombok (Disabled by default since we have kotlin now)

## Steps:
- Clone this repo locally using `git clone https://github.com/null-check/android-starterapp.git`
- Open the project using Android Studio
- Change package and application names. If you don't know how to do this, you can follow these steps:
- Open any java file. You will see `package com.sample_package_name.sample_application_name` as the first line of the file.
- Right click `sample_package_name` and choose `Refactor` > `Rename`. You will see a dialog with few options. Choose `Rename Package`.
- Type in your desired package name. Follow the same steps for `sample_application_name` as well.
- Modify values for `defaultApplicationId` and `defaultAppName` in `build.gradle` file and `app_name` inside `strings.xml`.

And you're all set! Happy developing.
