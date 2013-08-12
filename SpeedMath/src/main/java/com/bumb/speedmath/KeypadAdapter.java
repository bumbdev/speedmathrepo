package com.bumb.speedmath;

import android.*;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import com.bumb.speedmath.KeypadButtonCategory;
import com.bumb.speedmath.KeypadButtonEnum;

/**
 * Created by manisharora on 8/10/13.
 */

public class KeypadAdapter extends BaseAdapter{

    private Context context;
    private View.OnClickListener listener;
    public KeypadAdapter(Context ctx) {
        context = ctx;
    }

    public void setOnButtonClickListener(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    @Override
    public int getCount() {
        return buttons.length;
    }

    @Override
    public Object getItem(int position) {
        return buttons[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Button btn;
        if (KeypadButtonEnum.DUMMY == buttons[position]) {
            return new TextView(context);
            //return null;
        }
        if (view == null) { // if it's not recycled, initialize some attributes
            btn = new Button(context);
            KeypadButtonEnum keypadButton = buttons[position];

            // Set CalculatorButton enumeration as tag of the button so that we
            // will use this information from our main view to identify what to do
            btn.setTag(keypadButton);
            btn.setOnClickListener(listener);
        }
        else {
            btn = (Button) view;
        }

        btn.setText(buttons[position].getText());

        GameActivity activity = (GameActivity)context;
        //int gridHeight = activity.keypadGrid.getHeight();
        //int gridRows = getCount()/activity.keypadGrid.getNumColumns();
        //int buttonHeight =  gridHeight/GameActivity.NUM_COLUMNS_IN_KEYPAD -
                //activity.keypadGrid.getPaddingTop() - activity.keypadGrid.getPaddingBottom();
        //int buttonHeight = gridHeight/GameActivity.NUM_COLUMNS_IN_KEYPAD -
                //(int)activity.getVerticalSpacingInKeypad();
        //btn.setHeight(buttonHeight);
        //btn.setTextAppearance(context, android.R.style.TextAppearance_Large);

        btn.setBackgroundResource(R.drawable.keypadclear1);
        return btn;
    }

    private KeypadButtonEnum[] buttons = { KeypadButtonEnum.ONE, KeypadButtonEnum.TWO,
            KeypadButtonEnum.THREE, KeypadButtonEnum.FOUR, KeypadButtonEnum.FIVE,
            KeypadButtonEnum.SIX, KeypadButtonEnum.SEVEN, KeypadButtonEnum.EIGHT,
            KeypadButtonEnum.NINE, KeypadButtonEnum.DECIMAL, KeypadButtonEnum.ZERO,
            KeypadButtonEnum.DELETE, KeypadButtonEnum.CLEAR, KeypadButtonEnum.DUMMY,
            KeypadButtonEnum.GO};
}
