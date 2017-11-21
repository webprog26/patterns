package com.example.webprog26.patternstask.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.decorator.Car;
import com.example.webprog26.patternstask.decorator.CarDecorator;
import com.example.webprog26.patternstask.decorator.Kia;
import com.example.webprog26.patternstask.decorator.MoveableCarBackDecorator;
import com.example.webprog26.patternstask.template.OnClickFragment;

import butterknife.BindView;

/**
 * Created by webprog26 on 21.11.17.
 */

public class DecoratorFragment extends OnClickFragment {

    private static final String CEED = "ceed";

    private final Car kiaCar = new Kia(CEED);

    @BindView(R.id.tv_car_info)
    TextView mTvCarInfo;

    @BindView(R.id.btn_get_moving_car)
    Button mBtnGetMovingCar;

    @BindView(R.id.btn_move_car_back)
    Button mBtnMoveCarBack;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnGetMovingCar.setOnClickListener(this);
        mBtnMoveCarBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final StringBuilder stringBuilder = new StringBuilder();

        switch (view.getId()) {
            case R.id.btn_get_moving_car:
                stringBuilder.append(kiaCar.moveForward() + "\n")
                        .append(kiaCar.moveLeft() + "\n")
                        .append(kiaCar.moveRight() + "\n");
                break;
            case R.id.btn_move_car_back:
                CarDecorator moveableCarBackDecorator = new MoveableCarBackDecorator(CEED, kiaCar);
                stringBuilder.append(moveableCarBackDecorator.moveForward() + "\n")
                        .append(moveableCarBackDecorator.moveLeft() + "\n")
                        .append(moveableCarBackDecorator.moveRight() + "\n")
                        .append(moveableCarBackDecorator.moveBack());
                break;
        }
        mTvCarInfo.setText(stringBuilder.toString());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.decorator_fragment;
    }
}
