package com.google.ar.core.examples.java.augmentedfaces;

import android.util.Log;

import com.google.ar.core.Pose;
import com.google.ar.core.examples.java.common.AugmentedFace;
import com.google.ar.core.examples.java.common.rendering.Vector3;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.logging.Logger;

public class AugmentedFaceArCore extends AugmentedFace {
    com.google.ar.core.AugmentedFace myFace;
    Pose mouthPose;
    static int MouthIndex[] = {57,17,287};
    Vector3 directionLeft = new Vector3(0,0,0);
    Vector3 directionRight= new Vector3(0,0,0);
    AugmentedFaceArCore(com.google.ar.core.AugmentedFace face){
        myFace = face;
        populateMeshData();
        update();
    }

    @Override
    public void populateMeshData() {
        verticesBuffer = myFace.getMeshVertices();
        normalsBuffer = myFace.getMeshNormals();
        textureCoordinatesBuffer = myFace.getMeshTextureCoordinates();
        int n = verticesBuffer.limit()/3;
        triangleIndicesBuffer = ShortBuffer.allocate(n);
        //{57,17,287};
        for(short i = 0; i < n; i++)
            triangleIndicesBuffer.put(i);
        //triangleIndicesBuffer.put(mouth);
        triangleIndicesBuffer.rewind();

//        for(int i : mouth){
//
//            Log.i("Tag","ver "+ verticesBuffer.get(i*3)+"  "+verticesBuffer.get(i*3+1)+"  "+verticesBuffer.get(i*3+2));
//        }
    }

    @Override
    public void update(){
        centerPose = myFace.getCenterPose();
        float[] translation = centerPose.getTranslation();
        Log.i("fsdfsf","test center "+translation[0]+" "+translation[1]+" "+translation[2]);
        translation[0] = verticesBuffer.get(MouthIndex[1]*3+0);
        translation[1] = verticesBuffer.get(MouthIndex[1]*3+1);
        translation[2] = verticesBuffer.get(MouthIndex[1]*3+2);
        Log.i("fsdfsf","test mouth "+translation[0]+" "+translation[1]+" "+translation[2]);
        mouthPose = new Pose(translation,Pose.IDENTITY.getRotationQuaternion());
        //mouthPose = centerPose;

        directionLeft.set(verticesBuffer.get(MouthIndex[0]*3+0)-translation[0],verticesBuffer.get(MouthIndex[0]*3+1)-translation[1],verticesBuffer.get(MouthIndex[0]*3+2)-translation[2]);
        directionRight.set(verticesBuffer.get(MouthIndex[0]*3+0)-translation[0],verticesBuffer.get(MouthIndex[0]*3+1)-translation[1],verticesBuffer.get(MouthIndex[0]*3+2)-translation[2]);
        directionLeft.normalise();
        directionRight.normalise();
    }


    public Pose getRegionPose() {

        return mouthPose;
    }

    public Vector3 getDirectionLeft(){
        return directionLeft;
    }
    public Vector3 getDirectionRight(){
        return directionRight;
    }
}
