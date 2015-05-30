package cordova.plugin.rongcloud.im;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import java.util.HashMap;

import android.net.Uri;
import android.view.View;
import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import io.rong.app.activity.SOSOLocationActivity;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import io.rong.imlib.model.Message;
import io.rong.imkit.model.UIConversation;

/**
 * This class echoes a string called from JavaScript.
 */
public class RongCloudIm extends CordovaPlugin implements RongIM.GetUserInfoProvider, RongIM.ConversationBehaviorListener, RongIM.LocationProvider {
    HashMap<String, UserInfo> userInfos = new HashMap<String, UserInfo>();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("connect")) {
            this.connect(args.getString(0), callbackContext);
            return true;
        } else if (action.equals("init")) {
            this.init();
            return true;
        } else if (action.equals("startPrivateChat")) {
            this.startPrivateChat(args.getString(0), args.getString(1));
            return true;
        } else if (action.equals("startConversationList")) {
            this.startConversationList();
            return true;
        } else if (action.equals("startConversationGroupList")) {
            this.startConversationGroupList();
            return true;
        } else if (action.equals("addUserInfo")) {
            this.addUserInfo(args.getString(0), args.getString(1), args.getString(2));
            return true;
        }
        return false;
    }

    private void init() {
        RongIM.init(this.cordova.getActivity().getApplicationContext());
        RongIM.setGetUserInfoProvider(this, true);
        RongIM.setConversationBehaviorListener(this);
        RongIM.setLocationProvider(this);
    }

    // GetUserInfoProvider
    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfos.get(userId);
    }

    private void addUserInfo(String userId, String userName, String portraitUri) {
        try {
            userInfos.put(userId, new UserInfo(userId, userName, Uri.parse(portraitUri)));
        } catch (Exception e) {
        }
    }

    private void connect(String token, final CallbackContext callbackContext) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {

            @Override
            public void onSuccess(String userId) {
                callbackContext.success(userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode error) {
                callbackContext.error("Error: " + error);
            }
        });
    }

    private void startPrivateChat(String userId, String title) {
        RongIM.getInstance().startPrivateChat(this.cordova.getActivity(), userId, title);
    }

    private void startConversationList() {
        RongIM.getInstance().startConversationList(this.cordova.getActivity());
    }   

    private void startConversationGroupList() {
        RongIM.getInstance().startSubConversationList(this.cordova.getActivity(), Conversation.ConversationType.GROUP);
    }

    // ConversationBehaviorListener
    @Override
    public boolean onMessageClick(Context context, View view, Message message) {
        //if (message.getContent() instanceof LocationMessage) {
            //Intent intent = new Intent(context, SOSOLocationActivity.class);
            //intent.putExtra("location", message.getContent());
            //context.startActivity(intent);
        //}
        return false;
    }

    @Override
    public boolean onMessageLongClick(Context context, View view, Message message) {
        return false;
    }   

    @Override
    public boolean onConversationLongClick(Context context, View view, UIConversation uiConversation) {
        return false;
    }   

    @Override
    public boolean onConversationItemClick(Context context, View view, UIConversation uiConversation) {
        return false;
    }

    // ConversationBehaviorListener
    @Override
    public boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo user) {
        return false;
    }

    // LocationProvider
    @Override
    public void onStartLocation(Context context, LocationCallback callback) {
        //context.startActivity(new Intent(context, SOSOLocationActivity.class));
    }
}
