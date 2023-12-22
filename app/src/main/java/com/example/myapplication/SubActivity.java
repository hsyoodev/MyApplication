package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        GridView gridView = findViewById(R.id.grid_view);
        Integer[] srcs = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8
                , R.drawable.pic9};
        MyGridAdapter myGridAdapter = new MyGridAdapter(this, srcs);
        gridView.setAdapter(myGridAdapter);
        final String[] names = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서"
        };
        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder ab = new AlertDialog.Builder(SubActivity.this);
                ab.setTitle("[" + names[position] + "]");
                ab.setMessage("이 그림에 투표하시겠습니까?");
                ab.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        voteCount[position] += 1;
                        Toast.makeText(
                                SubActivity.this, "현재 투표 수 : " + voteCount[position],
                                Toast.LENGTH_SHORT).show();
                    }
                });
                ab.setNegativeButton("아니오", null);
                ab.show();
            }
        });
        Button btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, ResultActivity.class);
                // 투표결과 voteCount와 작품명 imgName 배열 변수를 넘겨주기
                intent.putExtra("voteCount", voteCount); // int 배열
                intent.putExtra("imgName", names); // String 배열
                startActivity(intent);
            }
        });
    }

    public class MyGridAdapter extends BaseAdapter {
        Activity act;
        Integer[] srcs;

        public MyGridAdapter(Activity act, Integer[] srcs) {
            this.act = act;
            this.srcs = srcs;
        }

        @Override
        public int getCount() {
            return srcs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(act);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(srcs[position]);
            return imageView;
        }
    }
}