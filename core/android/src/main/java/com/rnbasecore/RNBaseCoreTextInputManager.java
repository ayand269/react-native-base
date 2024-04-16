package com.rnbasecore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNBaseCoreManagerInterface;
import com.facebook.react.viewmanagers.RNBaseCoreManagerDelegate;

@ReactModule(name = RNBaseCoreTextInputManager.NAME)
public class RNBaseCoreTextInputManager extends SimpleViewManager<TextInput>
        implements RNBaseCoreManagerInterface<TextInput> {

  private final ViewManagerDelegate<TextInput> mDelegate;

    static final String NAME = "RNBaseCore";

    public RNBaseCoreTextInputManager(ReactApplicationContext context) {
        mDelegate = new RNBaseCoreManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<TextInput> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return RNBaseCoreTextInputManager.NAME;
    }

    @NonNull
    @Override
    protected TextInput createViewInstance(@NonNull ThemedReactContext context) {
        return new TextInput(context);
    }

    @Override
    @ReactProp(name = "text")
    public void setText(TextInput view, @Nullable String text) {
        view.setText(text);
    }
}