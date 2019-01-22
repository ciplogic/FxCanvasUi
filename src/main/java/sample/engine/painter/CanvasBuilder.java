/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.engine.painter;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author cipri
 */
public class CanvasBuilder {
    public Canvas canvas;
    public CanvasBuilder(int width, int height){
        canvas = new Canvas(width, height);
    }

    public CanvasPainter getPainter(int left, int top){
        return new CanvasPainter(left, top, canvas.getGraphicsContext2D());
    }
}
