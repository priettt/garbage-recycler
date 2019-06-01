package com.unicen.garbage.ui.main;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.unicen.garbage.R;

public class HorizontalNumberPicker extends LinearLayout {
    private TextInputEditText textInputEditText;
    private TextInputLayout textInputLayout;
    private int max = 9999;

    public HorizontalNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.numberpicker_horizontal, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.HorizontalNumberPicker);
        CharSequence title = arr.getString(R.styleable.HorizontalNumberPicker_pickerTitle);

        textInputEditText = findViewById(R.id.numberpick_edit);
        textInputLayout = findViewById(R.id.numberpick_input_layout);

        textInputLayout.setHint(title);

        final Button btn_less = findViewById(R.id.btn_less);
        btn_less.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInputEditText.getText() != null) {
                    int aux = Integer.parseInt(textInputEditText.getText().toString());
                    if (aux > 0) {
                        textInputEditText.setText(Integer.toString(aux - 1));
                    }
                }
            }
        });

        final Button btn_more = findViewById(R.id.btn_more);
        btn_more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInputEditText.getText() != null) {
                    if (textInputEditText.getText().toString().isEmpty()) {
                        textInputEditText.setText("0");
                    } else {
                        int aux = Integer.parseInt(textInputEditText.getText().toString());
                        if (aux < max) {
                            textInputEditText.setText(Integer.toString(aux + 1));
                        }
                    }
                }
            }
        });
    }

    /***
     * GETTERS & SETTERS
     */

    @NonNull
    public String getValue() {
        if (textInputEditText != null) {
            try {
                if (textInputEditText.getText() != null) {
                    return textInputEditText.getText().toString();
                }
            } catch (NumberFormatException ex) {
                Log.e("HorizontalNumberPicker", ex.toString());
            }
        }
        return "0";
    }

    public void setValue(@NonNull String value) {
        if (textInputEditText != null) {
            textInputEditText.setText(value);
        }
    }
}