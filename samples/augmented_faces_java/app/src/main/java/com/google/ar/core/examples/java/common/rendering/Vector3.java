package com.google.ar.core.examples.java.common.rendering;

public  class Vector3 {
    private double x,y,z;

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    double getZ() {
        return z;
    }

    public Vector3(double ix, double iy) {
        x = ix;
        y = iy;
        z = (double) 0;
    }

    public Vector3(double ix, double iy, double iz) {
        x = ix;
        y = iy;
        z = iz;
    }

    public void set(double ix, double iy, double iz) {
        x = ix;
        y = iy;
        z = iz;
    }

    public double magnitude() {
        return Math.sqrt(x*x+y*y+z*z);
    }

    public Vector3 normalise() {
        double mag = magnitude();
        x /= mag;
        y /= mag;
        z /= mag;

        return this;
    }

    public double dot(Vector3 b){
        return this.x*b.x + this.y*b.y + this.z*b.z;
    }

    public double angle(Vector3 b){
        return Math.acos(this.dot(b)/(this.magnitude()*b.magnitude()));
    }
    /*
    * cx = aybz − azby
cy = azbx − axbz
cz = axby − aybx*/
    public Vector3 cross(Vector3 b){
        return new Vector3(this.y*b.z - this.z*b.y,this.z*b.x - this.x*b.z,this.x*b.y - this.y*b.x);
    }
}