package com.example.webprog26.patternstask.visitor;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public interface Item {

    String accept(@NonNull final Visitor visitor);
}
