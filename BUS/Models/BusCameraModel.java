
package BUS.Models;

public class BusCameraModel {
    private int maCamera;
    private String tenCamera;
    private String doPhanGiai;
    private boolean trangThai;
 
    public BusCameraModel(int maCamera, String tenCamera, String doPhanGiai, boolean trangThai) {
        this.maCamera = maCamera;
        this.tenCamera = tenCamera;
        this.doPhanGiai = doPhanGiai;
        this.trangThai = trangThai;
    }

    public BusCameraModel(int maCamera, String tenCamera, String doPhanGiai) {
        this.maCamera = maCamera;
        this.tenCamera = tenCamera;
        this.doPhanGiai = doPhanGiai;
    }

    public BusCameraModel() {
    }

    public int getMaCamera() {
        return maCamera;
    }

    public void setMaCamera(int maCamera) {
        this.maCamera = maCamera;
    }

    public String getTenCamera() {
        return tenCamera;
    }

    public void setTenCamera(String tenCamera) {
        this.tenCamera = tenCamera;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenCamera  + " - "+doPhanGiai;
    }
    
    
}
