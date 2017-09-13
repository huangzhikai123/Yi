package com.example.lenovo.yi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bT = (Button) this.findViewById(R.id.button1);
        bT.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("请点击登录按钮")
                        .setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "明白了", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

        Button button = (Button) this.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view=inflater.inflate(R.layout.login_dialog, null);
                builder.setView(view)
                        .setTitle("Login")
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    EditText Id =(EditText)view.findViewById(R.id.editTextUserId);
                    EditText M =(EditText)view.findViewById(R.id.editTextPwd);
                    String uId = Id.getText().toString();
                    String Mi = M.getText().toString();
                    if(uId.equals("abc") && Mi.equals("123"))
                    {
                        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
                    }
                }
            })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            Toast.makeText(MainActivity.this, "用户取消登录", Toast.LENGTH_LONG).show();
                        }
                    });
                builder.show();
            }
        });
    }
}
