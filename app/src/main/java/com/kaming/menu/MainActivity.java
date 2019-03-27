package com.kaming.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_menu,btn_popmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_menu = (Button) findViewById(R.id.btn_contectmenu);
        btn_popmenu = (Button) findViewById(R.id.btn_popup);
        //longClick會發生
        btn_menu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //發生ActionMode中的
                startActionMode(cb);
                return false;
            }
        });
        btn_popmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //實體化popupMenu對象 顯示在(btn_popmenu)
                PopupMenu menu1 = new PopupMenu(MainActivity.this,btn_popmenu);
                //獲取menu位置
                menu1.getMenuInflater().inflate(R.menu.popup,menu1.getMenu());
                //讓menu item have function
                menu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.item1:
                                Toast.makeText(MainActivity.this,"item1",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(MainActivity.this,"item2",Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
                //必需的一步
                menu1.show();
            }
        });
        //Register ContextMenu
//        registerForContextMenu(findViewById(R.id.btn_contectmenu));
    }

    //建ActionMode CallBack對象
    ActionMode.Callback cb  = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //使用Menu位置
            getMenuInflater().inflate(R.menu.context,menu);
            Log.e("TAG","創建");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.e("TAG","準備");
            return false;
        }

        //clicked option
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.item1:
                    Toast.makeText(MainActivity.this,"item1",Toast.LENGTH_LONG).show();
                    break;
                case R.id.item2:
                    Toast.makeText(MainActivity.this,"item2",Toast.LENGTH_LONG).show();
                    break;
                case R.id.item3:
                    Toast.makeText(MainActivity.this,"item3",Toast.LENGTH_LONG).show();
                    break;
            }
            Log.e("TAG","click");
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.e("TAG","End");
        }
    };

//    //Create Context Menu get R.menu.
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.context,menu);
//    }
//
//    //Context Menu item
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.item1:
//                Toast.makeText(this,"item1",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.item2:
//                Toast.makeText(this,"item2",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.item3:
//                Toast.makeText(this,"item3",Toast.LENGTH_LONG).show();
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }

    //display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu位置,參數
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //設置option menu的選項會發生的事
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.out:
                finish();
                break;
            case R.id.setting:
                Toast.makeText(this,"設置",Toast.LENGTH_LONG).show();
                break;
            case R.id.save:
                Toast.makeText(this,"保存",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
