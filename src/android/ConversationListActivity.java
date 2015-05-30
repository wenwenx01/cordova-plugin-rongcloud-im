package cordova.plugin.rongcloud.im;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ConversationListActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getApplicationContext().getResources()
                .getIdentifier("conversationlist", "layout", getApplicationContext().getPackageName()));
        getSupportActionBar().setTitle("会话列表");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getApplicationContext().getResources()
                .getIdentifier("im_actionbar_back", "drawable", getApplicationContext().getPackageName()));
    }  
}
