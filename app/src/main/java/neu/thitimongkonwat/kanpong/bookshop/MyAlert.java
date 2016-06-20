package neu.thitimongkonwat.kanpong.bookshop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by iMac_16 on 6/20/2016 AD.
 */
public class MyAlert {

    public void MyDialog(Context context,
                         String strTitle,
                         String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);   //undo andriod
        builder.setIcon(R.drawable.rat48); //รูปแจ้งเตือน
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); //ให้ข้อความหาย
            }
        });
        builder.show();
    }

} //Main Class
