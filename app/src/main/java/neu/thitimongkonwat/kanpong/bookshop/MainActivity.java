package neu.thitimongkonwat.kanpong.bookshop;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity { //Main Class

    //Explicit
    private EditText userEditext, passwordEditText;
    private String userString, passwordString;
    private static final String urlJSon = "http://swiftcodingthai.com/neu/get_user.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main Method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget

        userEditext = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);

    } //End Method เมธอดหลัก

    //Create Inner Class
    private class MySynchronize extends AsyncTask<Void, Void, String> {

        private Context context;
        private String urlString;

        public MySynchronize(Context context, String urlString) {
            this.context = context;
            this.urlString = urlString;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlString).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                return null;
            }

        } //Do In Back

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("BookShopV1", "JSON ==>" +s);
        }
    } //End Inner Class


    public void clickSignIn(View view) { //Get value Edit text
        userString = userEditext.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Spec

        if (userString.equals("") || passwordString.equals("")) { //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.MyDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");

        } else {

            searchUserAnPassword();

        }
    }//end Edit text

    private void searchUserAnPassword() { //search_User

        MySynchronize mySynchronize = new MySynchronize(this, urlJSon);
        mySynchronize.execute();

    }

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

} //End Class นี่คือ คลาสหลัก
