package com.kidoz.mediation.admob.adapters;

import android.app.Activity;
import android.util.Log;

import com.kidoz.sdk.api.KidozInterstitial;
import com.kidoz.sdk.api.KidozSDK;
import com.kidoz.sdk.api.interfaces.SDKEventListener;
import com.kidoz.sdk.api.ui_views.interstitial.BaseInterstitial;
import com.kidoz.sdk.api.ui_views.kidoz_banner.KidozBannerListener;
import com.kidoz.sdk.api.ui_views.new_kidoz_banner.BANNER_POSITION;
import com.kidoz.sdk.api.ui_views.new_kidoz_banner.KidozBannerView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by orikam on 07/06/2017.
 */

public class KidozManager
{

    private KidozInterstitial mKidozInterstitial;
    private KidozInterstitial mKidozRewarded;
    private KidozBannerView mKidozBanner;
    private static final String TAG = "KidozManager";


    private static String mKidozPublisherId = ""; //default (test values)
    private static String mKidozPublisherToken = ""; //default (test values)
    private static BaseInterstitial.IOnInterstitialRewardedEventListener mDeveloperRewardedListener;

    /****************************
     *      Developer API       *
     ****************************/
    public static void setKidozPublisherId(String publisherId){
        mKidozPublisherId = publisherId;
    }

    public static void setKidozPublisherToken(String publisherToken){
        mKidozPublisherToken = publisherToken;
    }

    public static void setRewardedEvents(BaseInterstitial.IOnInterstitialRewardedEventListener rewardedListener){
        mDeveloperRewardedListener = rewardedListener;
    }

    /****************************
     *     Adapter Internal     *
     ****************************/

    protected void setupKidozBanner(Activity activity, BANNER_POSITION bannerPosition, KidozBannerListener kidozBannerListener){
        mKidozBanner = KidozSDK.getKidozBanner(activity);
        mKidozBanner.setBannerPosition(bannerPosition);
        mKidozBanner.setKidozBannerListener(kidozBannerListener);
    }

    protected void setupKidozInterstitial(Activity activity, BaseInterstitial.IOnInterstitialEventListener interstitialListener){
        mKidozInterstitial = new KidozInterstitial(activity, KidozInterstitial.AD_TYPE.INTERSTITIAL);
        mKidozInterstitial.setOnInterstitialEventListener(interstitialListener);
    }

    protected void setupKidozRewadrded(Activity activity, BaseInterstitial.IOnInterstitialEventListener interstitialListener, BaseInterstitial.IOnInterstitialRewardedEventListener rewardedListener){
        mKidozRewarded = new KidozInterstitial(activity, KidozInterstitial.AD_TYPE.REWARDED_VIDEO);
        mKidozRewarded.setOnInterstitialEventListener(interstitialListener);
        mKidozRewarded.setOnInterstitialRewardedEventListener(rewardedListener);
    }

    protected void initKidozSDK(Activity activity, SDKEventListener sdkEventsListener)
    {
        KidozSDK.setSDKListener(sdkEventsListener);
        KidozSDK.initialize(activity, mKidozPublisherId, mKidozPublisherToken);
    }

    protected boolean getIsKidozInitialized(){
        return KidozSDK.isInitialised();
    }

    protected KidozBannerView getBanner() { return mKidozBanner; }

    protected KidozInterstitial getInterstitial(){
        return mKidozInterstitial;
    }

    protected KidozInterstitial getRewarded(){
        return mKidozRewarded;
    }

    protected BaseInterstitial.IOnInterstitialRewardedEventListener getDeveloperRewardedListener(){
        return mDeveloperRewardedListener;
    }

    protected static String getPublisherIdFromParams(String params) {
        String appID = null;
        if (params != null && !params.equals("")) {
            JSONObject jsonParams ;
            try
            {
                jsonParams = new JSONObject(params);
                if (jsonParams!=null && jsonParams.has("AppID"))
                    appID = jsonParams.getString("AppID");
                else
                    Log.d(TAG, "Kidoz | PublisherId parameter - Token AppID");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(TAG, "Kidoz | PublisherId parameter error");
            }
        }else {
            Log.d(TAG, "Kidoz | PublisherId parameter empty");
        }
        return appID;
    }


    protected static String getPublisherTokenFromParams(String params) {
        String token = null;
        if (params != null && !params.equals("")) {
            JSONObject jsonParams ;
            try
            {
                jsonParams = new JSONObject(params);
                if (jsonParams!=null && jsonParams.has("Token"))
                    token = jsonParams.getString("Token");
                else
                    Log.d(TAG, "Kidoz | PublisherToken parameter - Token error");

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(TAG, "Kidoz | PublisherToken parameter error");
            }

        }else {
            Log.d(TAG, "Kidoz | PublisherToken parameter empty");
        }
        return token;
    }
}