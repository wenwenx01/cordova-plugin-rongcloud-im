package cordova.plugin.rongcloud.im;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * This class echoes a string called from JavaScript.
 */
public class RongCloudIm extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("connect")) {
            this.connect(args.getString(0), callbackContext);
            return true;
        } else if (action.equals("init")) {
            this.init();
            return true;
        }
        return false;
    }

    private void init() {
        RongIM.init(this.cordova.getActivity().getApplicationContext());
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
}
