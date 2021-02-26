package com.uma.creditscoreui.widgets

import android.view.animation.Animation
import android.view.animation.Transformation
import com.uma.creditscoreui.widgets.Circle


class CircleAngleAnimation(private val circle: Circle, private val newAngle: Int) : Animation() {

    private val oldAngle: Float = circle.angle

    override fun applyTransformation(interpolatedTime: Float, transformation: Transformation) {
        circle.angle = (oldAngle) + ((newAngle) - (oldAngle)) * interpolatedTime
        circle.requestLayout()
    }
}