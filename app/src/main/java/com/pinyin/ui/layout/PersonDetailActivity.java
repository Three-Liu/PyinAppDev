package com.pinyin.ui.layout;

import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.Person;
import com.pinyin.ui.utils.FastBlurUtil;
import com.pinyin.utils.BitmapByteDrawable;
import com.pinyin.utils.MyApplication;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonDetailActivity extends AppCompatActivity {
    private ImageView imageView, gender,back;
    private CircleImageView circleImageView;
    private FloatingActionButton floatingActionButton;
    private LinearLayout first_container;
    private RelativeLayout second;
    private boolean status;
    private Person person;
    private RadioGroup radioGroup;
    private TextView person_name, person_tel, person_nik, person_birth, person_address,
            person_edit_nik, person_edit_birth, person_edit_tel;
    private boolean sex;
    private EditText person_edit_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        int blurRadius = 8;
        int scaleRatio = 30;

        init();

        //mipmap to bitmap and aero glass
        Bitmap originBitmap = person.getHead();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originBitmap,
                originBitmap.getWidth() / scaleRatio,
                originBitmap.getHeight() / scaleRatio,
                false);
        Bitmap blurBitmap = FastBlurUtil.doBlur(scaledBitmap, blurRadius, true);


        //set image
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(blurBitmap);
        circleImageView.setImageBitmap(originBitmap);


        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        status = false;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!status) {
                    first_container.setVisibility(View.INVISIBLE);
                    second.setVisibility(View.VISIBLE);
                    openEdit(floatingActionButton);
                    status = true;
                } else {
                    first_container.setVisibility(View.VISIBLE);
                    second.setVisibility(View.INVISIBLE);
                    closeEdit(floatingActionButton);
                    person_birth.setText(person_edit_birth.getText().toString());
                    if (sex) {
                        person.setGender(sex);
                        gender.setImageDrawable(getResources().getDrawable(R.mipmap.person_sex_male));
                    } else {
                        person.setGender(sex);
                        gender.setImageDrawable(getResources().getDrawable(R.mipmap.person_sex_female));
                    }
                    if(!person_nik.getText().equals(person_edit_nik.getText())) {
                        person_nik.setText(person_edit_nik.getText().toString());
                        person.setNikname(person_nik.getText().toString());
                    }
                    if(!person_address.getText().equals(person_edit_address.getText())) {
                        person_address.setText(person_edit_address.getText().toString());
                        person.setAddress(person_address.getText().toString());
                    }
                    status = false;
                }
            }
        });

        person_edit_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(PersonDetailActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        person_edit_birth.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        person.setBirth(person_edit_birth.getText().toString());
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int button = radioGroup.getCheckedRadioButtonId();
                if (button == R.id.sex_male)
                    sex = true;
                else
                    sex = false;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void openEdit(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, -155, -135);
        animator.setDuration(500);
        animator.start();
    }

    private void closeEdit(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", -135, 20, 0);
        animator.setDuration(500);
        animator.start();
    }

    private void init() {
        //person init
        MyApplication application= (MyApplication)getApplication();
        person = application.getPerson();
        //view init
        radioGroup = (RadioGroup) findViewById(R.id.ac_edit_person_gender);
        imageView = (ImageView) findViewById(R.id.profile_image_bg);
        back = (ImageView) findViewById(R.id.back_button);
        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        first_container = (LinearLayout) findViewById(R.id.first_container);
        second = (RelativeLayout) findViewById(R.id.info_edit_container);

        person_name = (TextView) findViewById(R.id.ac_person_name);
        person_birth = (TextView) findViewById(R.id.ac_person_birth);
        person_address = (TextView) findViewById(R.id.ac_person_address);
        person_tel = (TextView) findViewById(R.id.ac_person_tel);
        person_nik = (TextView) findViewById(R.id.ac_person_nick);

        person_edit_address = (EditText) findViewById(R.id.ac_edit_person_address);
        person_edit_nik = (TextView) findViewById(R.id.ac_edit_person_nick);
        person_edit_birth = (TextView) findViewById(R.id.ac_edit_person_birth);

        gender = (ImageView) findViewById(R.id.ac_person_gender);

        if (person.isGender()) {
            gender.setImageDrawable(getResources().getDrawable(R.mipmap.person_sex_male));
            radioGroup.check(R.id.sex_male);
        }else {
            gender.setImageDrawable(getResources().getDrawable(R.mipmap.person_sex_female));
            radioGroup.check(R.id.sex_female);

        }
        person_tel.setText(person.getTel());
        person_name.setText(person.getName());
        person_nik.setText(person.getNikname());
        person_address.setText(person.getAddress());
        person_birth.setText(person.getBirth());

        person_edit_nik.setText(person_nik.getText().toString());
        person_edit_address.setText(person_address.getText().toString());

    }
}
