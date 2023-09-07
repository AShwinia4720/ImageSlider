package in.androidlearning.imagesliderwithasynctask;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ImageSliderDialog extends Dialog {
    private TextView txtTitle, txtImgNo;
    private ImageView imgView;
    private Button btnCancel;
    int index =0;


    public ImageSliderDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_imageslider);
        inThisView();
        btnCancel.setOnClickListener(new OnCancelBtnClickListener());
        ImagesliderThread img1 = new ImagesliderThread();
        img1.execute();
    }

    private void inThisView() {
        txtTitle = findViewById(R.id.txtTitle);
        imgView = findViewById(R.id.imgView);
        btnCancel = findViewById(R.id.btnCancel);
        txtImgNo = findViewById(R.id.txtImgNo);
    }

    private class OnCancelBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    }

    public static int[] images = {R.drawable.banner11,R.drawable.banner12,
            R.drawable.banner13,R.drawable.banner14};


    public class ImagesliderThread extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int i=0;
            for (i = 0; i < images.length; i++) {

                publishProgress(i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
                if(index>=images.length){
                    index=0;
                }

                imgView.setImageResource(images[index]);
                txtImgNo.setText(index+1 + " of "+images.length);
                index++;

        }

        @Override
            protected void onPostExecute (Integer integer){
                super.onPostExecute(integer);
                }
            }
        }


