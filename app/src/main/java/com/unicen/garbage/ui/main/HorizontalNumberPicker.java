package com.unicen.garbage.ui.main;

import android.content.Context;
import android.content.res.TypedArray;
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
    private int min, max;

    public HorizontalNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.numberpicker_horizontal, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.HorizontalNumberPicker);
        CharSequence title = arr.getString(R.styleable.HorizontalNumberPicker_pickerTitle);

        textInputEditText = findViewById(R.id.numberpick_edit);
        textInputLayout = findViewById(R.id.numberpick_input_layout);

        textInputLayout.setHint(title);

        final Button btn_less = findViewById(R.id.btn_less);
        btn_less.setOnClickListener(new AddHandler(-1));

        final Button btn_more = findViewById(R.id.btn_more);
        btn_more.setOnClickListener(new AddHandler(1));
    }

    /***
     * HANDLERS
     **/

    private class AddHandler implements OnClickListener {
        final int diff;

        public AddHandler(int diff) {
            this.diff = diff;
        }

        @Override
        public void onClick(View v) {
            int newValue = getValue() + diff;
            if (newValue < min) {
                newValue = min;
            } else if (newValue > max) {
                newValue = max;
            }
            textInputEditText.setText(String.valueOf(newValue));
        }
    }

    /***
     * GETTERS & SETTERS
     */

    public int getValue() {
        if (textInputEditText != null) {
            try {
                final String value = textInputEditText.getText().toString();
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                Log.e("HorizontalNumberPicker", ex.toString());
            }
        }
        return 0;
    }

    public void setValue(final int value) {
        if (textInputEditText != null) {
            textInputEditText.setText(String.valueOf(value));
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}