package cordova.plugin.rongcloud.im;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ConversationActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getApplicationContext().getResources()
                .getIdentifier("conversation", "layout", getApplicationContext().getPackageName()));
        getSupportActionBar().setTitle("会话");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getApplicationContext().getResources()
                .getIdentifier("im_actionbar_back", "drawable", getApplicationContext().getPackageName()));
    }  
}
