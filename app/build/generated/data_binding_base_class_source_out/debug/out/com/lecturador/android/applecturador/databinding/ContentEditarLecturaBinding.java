// Generated by view binder compiler. Do not edit!
package com.lecturador.android.applecturador.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import com.lecturador.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ContentEditarLecturaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private ContentEditarLecturaBinding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentEditarLecturaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentEditarLecturaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_editar_lectura, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentEditarLecturaBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ContentEditarLecturaBinding((ConstraintLayout) rootView);
  }
}
