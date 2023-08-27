package in.androidlearning.imagesliderwithasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnToProcessOnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inThisView();
        btnToProcessOnMain.setOnClickListener(new OnImageProcessBtnListener());
    }

    private void inThisView(){
        btnToProcessOnMain=findViewById(R.id.btnToProcessOnMain);
    }

    private class OnImageProcessBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            ImageSliderDialog imageSliderDialog = new ImageSliderDialog(MainActivity.this);
            imageSliderDialog.show();
        }
    }
}