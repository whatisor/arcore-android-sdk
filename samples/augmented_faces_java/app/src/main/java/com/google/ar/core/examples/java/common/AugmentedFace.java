package com.google.ar.core.examples.java.common;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import com.google.ar.core.Pose;

public class AugmentedFace {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

    protected static final String TAG = "AugmentedFace";
    protected FloatBuffer verticesBuffer;
    protected FloatBuffer normalsBuffer;
    protected FloatBuffer textureCoordinatesBuffer;
    protected ShortBuffer triangleIndicesBuffer;
    protected Pose centerPose = Pose.IDENTITY;

    public AugmentedFace() {
    }

    protected void populateMeshData() {
        verticesBuffer = FloatBuffer.allocate(0);
        normalsBuffer = FloatBuffer.allocate(0);
        textureCoordinatesBuffer = FloatBuffer.allocate(0);
        triangleIndicesBuffer = ShortBuffer.allocate(0);
    }

    //update pose,data in realime
    protected void update() {

    }

    public Pose getCenterPose() {
        return centerPose;
    }


    public FloatBuffer getMeshVertices() {
        return this.verticesBuffer;
    }

    public FloatBuffer getMeshNormals() {
        return this.normalsBuffer;
    }

    public FloatBuffer getMeshTextureCoordinates() {
        return this.textureCoordinatesBuffer;
    }

    public ShortBuffer getMeshTriangleIndices() {
        return this.triangleIndicesBuffer;
    }

}
