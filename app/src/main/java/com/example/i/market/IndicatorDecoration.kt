package com.example.i.market

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IndicatorDecoration: RecyclerView.ItemDecoration() {

    private var paintStroke: Paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.rgb(0x94, 0xb4, 0x9f)
    }

    private val paintFill = Paint().apply {
        style = Paint.Style.FILL
        color = Color.rgb(0x94, 0xb4, 0x9f)
    }

    // save the center coordinates of all indicators
    private val indicators = mutableListOf<Pair<Float, Float>>()

    private val indicatorRadius = 20f
    private val indicatorPadding = 150f

    private var activeIndicator = 0
    private var isInitialized = false

    // create three indicators for three slides
    override fun onDrawOver(canvas: Canvas,
                            parent: RecyclerView,
                            state: RecyclerView.State) {

        if(!isInitialized) {
            setupIndicators(parent)
        }

        // draw three indicators with stroke style
        parent.adapter?.let {
            with(canvas) {
                drawCircle(indicators[0].first, indicators[0].second)
                drawCircle(indicators[1].first, indicators[1].second)
                drawCircle(indicators[2].first, indicators[2].second)
            }

            val visibleItem = (parent.layoutManager as GridLayoutManager)
                .findFirstCompletelyVisibleItemPosition()

            if(visibleItem >= 0) {
                activeIndicator = visibleItem
            }

            // paint over the needed circle
            when (activeIndicator) {
                0 -> canvas.drawCircle(indicators[0].first, indicators[0].second, true)
                1 -> canvas.drawCircle(indicators[1].first, indicators[1].second, true)
                2 -> canvas.drawCircle(indicators[2].first, indicators[2].second, true)
            }
        }
    }

    private fun Canvas.drawCircle(x: Float, y: Float, isFill: Boolean = false) {
        drawCircle(x, y, indicatorRadius, if(isFill) paintFill else paintStroke)
    }

    private fun setupIndicators(recyclerView: RecyclerView) {
        isInitialized = true

        val indicatorTotalWidth = indicatorRadius * 6 + indicatorPadding * 2
        val indicatorPosX = (recyclerView.width - indicatorTotalWidth) / 2f
        val indicatorPosY = recyclerView.height - (indicatorRadius * 4 / 2f)

        indicators.add(indicatorPosX to indicatorPosY)
        indicators.add((indicatorPosX + (indicatorRadius * 2) + indicatorPadding) to indicatorPosY)
        indicators.add((indicatorPosX + (indicatorRadius * 4) + (indicatorPadding * 2)) to indicatorPosY)
    }
}