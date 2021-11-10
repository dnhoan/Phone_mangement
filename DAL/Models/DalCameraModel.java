
package DAL.Models;

public class DalCameraModel {
    private String maCamera;
    private String tenCamera;
    private String doPhanGiai;
    private boolean trangThai;

    public DalCameraModel(String maCamera, String tenCamera, String doPhanGiai, boolean trangThai) {
        this.maCamera = maCamera;
        this.tenCamera = tenCamera;
        this.doPhanGiai = doPhanGiai;
        this.trangThai = trangThai;
    }

    public String getMaCamera() {
        return maCamera;
    }

    public void setMaCamera(String maCamera) {
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
    
    
}
