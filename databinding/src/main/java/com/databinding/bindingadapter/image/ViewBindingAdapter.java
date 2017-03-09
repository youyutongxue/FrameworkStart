package com.databinding.bindingadapter.image;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {

    @BindingAdapter({"uri"})
    public static void loadImage(ImageView imageView, String uri) {
        if (!TextUtils.isEmpty(uri)) {
            Glide.with(imageView.getContext()).load(uri).into(imageView);
        }
    }

    @BindingAdapter(value = {"uri", "placeholderImageRes", "errorImageRes"}, requireAll = false)
    public static void loadImage(final ImageView imageView, String uri,
                                 @DrawableRes int placeholderImageRes,
                                 @DrawableRes int errorImageRes) {
        Glide.with(imageView.getContext()).load(uri).placeholder(placeholderImageRes).error(errorImageRes).into(imageView);
    }


    @BindingAdapter(value = {"circleUri", "placeholderImageRes", "errorImageRes"}, requireAll = false)
    public static void loadCircleImage(final ImageView imageView, String circleUri,
                                       @DrawableRes int placeholderImageRes,
                                       @DrawableRes int errorImageRes) {
        Glide.with(imageView.getContext()).load(circleUri).transform(new CircleTransform(imageView.getContext())).placeholder(placeholderImageRes).error(errorImageRes).into(imageView);
    }

    @BindingAdapter(value = {"roundUri", "placeholderImageRes", "errorImageRes"}, requireAll = false)
    public static void loadRoundImage(final ImageView imageView, String circleUri,
                                       @DrawableRes int placeholderImageRes,
                                       @DrawableRes int errorImageRes) {
        Glide.with(imageView.getContext()).load(circleUri).transform(new RoundTransfrom(imageView.getContext(), 10)).placeholder(placeholderImageRes).error(errorImageRes).into(imageView);
    }

}

