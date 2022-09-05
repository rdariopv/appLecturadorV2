// Generated by view binder compiler. Do not edit!
package com.lecturador.android.applecturador.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lecturador.android.applecturador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMenuPrincipalBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAjustes;

  @NonNull
  public final Button btnLecturar;

  @NonNull
  public final Button btnSyncAC;

  @NonNull
  public final TextView textView;

  private ActivityMenuPrincipalBinding(@NonNull LinearLayout rootView, @NonNull Button btnAjustes,
      @NonNull Button btnLecturar, @NonNull Button btnSyncAC, @NonNull TextView textView) {
    this.rootView = rootView;
    this.btnAjustes = btnAjustes;
    this.btnLecturar = btnLecturar;
    this.btnSyncAC = btnSyncAC;
    this.textView = textView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMenuPrincipalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMenuPrincipalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_menu_principal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMenuPrincipalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAjustes;
      Button btnAjustes = ViewBindings.findChildViewById(rootView, id);
      if (btnAjustes == null) {
        break missingId;
      }

      id = R.id.btnLecturar;
      Button btnLecturar = ViewBindings.findChildViewById(rootView, id);
      if (btnLecturar == null) {
        break missingId;
      }

      id = R.id.btnSyncAC;
      Button btnSyncAC = ViewBindings.findChildViewById(rootView, id);
      if (btnSyncAC == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityMenuPrincipalBinding((LinearLayout) rootView, btnAjustes, btnLecturar,
          btnSyncAC, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
