# KIDOZ_ADMOB_ADAPTER
Kidoz AdMob mediation adapter
</br>

***Please note - Currently Admob mediation is not available for Apps opt-in to Designed For Families program. Google should add this support by February-March 2018.
Till then, you can integrate KIDOZ ads directly to your apps.
    
**Prerequisits:**
* To use the Kidoz SDK adapter for AdMob you should make sure you have:
1. AdMob Mediation integrated in your project.
2. A fully functional AdMob ad placement.
3. Kidoz SDK built with your project.

3.1. You can get Kidoz SDK as a Gradle dependency (together with it's needed dependencies) using the following lines:
```
    compile group: 'org.greenrobot', name: 'eventbus', version: '3.0.0'
    compile 'com.android.support:support-v4:23.0.+'
    compile 'com.kidoz.sdk:KidozSDK:0.8.2.1@aar'
```

3.2. Please make sure you have a set up Kidoz publisher account.

3.3. The plugin itself consists of the java files inside the 'pluginFiles' directory, copy this entire package to your own project.

3.4. Set your Kidoz PublisherId & PublisherToken in the adapter using the following:
```
KidozManager.setKidozPublisherId(<publisherId>)
KidozManager.setKidozPublisherToken(<publisherToken>)

Or set a Custom Events Parameter:

 For Banner:
 {"AppID":"publisherId", "Token":"publisherToken"}

 For Interstitial:
 {"AppID":"publisherId", "Token":"publisherToken"}

 For Rewarded Video:
 {"AppID":"publisherId", "Token":"publisherToken"}
 
```
3.5. If you want to connect directly with the Kidoz reward events use the following:
```
KidozManager.setRewardedEvents(<new BaseInterstitial.IOnInterstitialRewardedEventListener>);
```
</br>

**Integration Steps:**

* Include the 'com.kidoz.mediation.admob.adapters' package in your project.

* Define Kidoz Interstitial and/or Rewarded Video Custom events as explained [HERE](https://support.google.com/admob/answer/3083407):
 
## KIDOZ Interstitial Adapter
* Set the following full path in the `Class Name` field: </br>
(Example: com.kidoz.mediation.admob.adapters.KidozAdMobMediationInterstitialAdapter.java)
</br>
## KIDOZ Rewarded Video Adapter
* Set the following full path in the `Class Name` field: </br>
(Example: com.kidoz.mediation.admob.adapters.KidozAdMobMediationRewardedAdapter.java)
</br>
## KIDOZ Banner Adapter
* Set the following full path in the `Class Name` field: </br>
(Example: com.kidoz.mediation.admob.adapters.KidozAdMobMediationBannerAdapter.java)
</br>
* Please Note: you can change the Kidoz adapter classpath in your project but maker sure the class names you put in the AdMob dashboard correspond to your final adapter location.

 

</br> 

License:

    Copyright 2015 KIDOZ, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

