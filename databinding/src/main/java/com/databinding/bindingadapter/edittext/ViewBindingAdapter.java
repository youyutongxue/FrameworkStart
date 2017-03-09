package com.databinding.bindingadapter.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.databinding.command.ReplyCommand;


/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {


    @android.databinding.BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(EditText editText, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            editText.setFocusableInTouchMode(true);
            editText.setSelection(editText.getText().length());
            editText.requestFocus();
            InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        } else {
            editText.setEnabled(false);
            editText.setEnabled(true);
        }

    }

    @android.databinding.BindingAdapter({"drawableRight"})
    public static void setDrawableRight(TextView textView, int leftResId) {
        if (leftResId > 0)
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null,
                    textView.getContext().getResources().getDrawable(leftResId), null);
        else
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @android.databinding.BindingAdapter({"drawableLeft"})
    public static void setDrawableLeft(TextView textView, int leftResId) {
        if (leftResId > 0)
            textView.setCompoundDrawablesWithIntrinsicBounds(textView.getContext().getResources().getDrawable(leftResId), null, null,
                    null);
        else
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @android.databinding.BindingAdapter({"paintFlag"})
    public static void setPaintFlag(TextView textView, int flag) {
        textView.getPaint().setFlags(flag);
    }


    @android.databinding.BindingAdapter(value = {"beforeTextChangedCommand", "onTextChangedCommand", "afterTextChangedCommand"}, requireAll = false)
    public static void editTextCommand(EditText editText,
                                       final ReplyCommand<TextChangeDataWrapper> beforeTextChangedCommand,
                                       final ReplyCommand<TextChangeDataWrapper> onTextChangedCommand,
                                       final ReplyCommand<String> afterTextChangedCommand) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (beforeTextChangedCommand != null) {
                    beforeTextChangedCommand.execute(new TextChangeDataWrapper(s, start, count, count));
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (onTextChangedCommand != null) {
                    onTextChangedCommand.execute(new TextChangeDataWrapper(s, start, before, count));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (afterTextChangedCommand != null) {
                    afterTextChangedCommand.execute(s.toString());
                }
            }
        });
    }

    public static class TextChangeDataWrapper {
        public CharSequence s;
        public int start;
        public int before;
        public int count;

        public TextChangeDataWrapper(CharSequence s, int start, int before, int count) {
            this.s = s;
            this.start = start;
            this.before = before;
            this.count = count;
        }
    }


}

