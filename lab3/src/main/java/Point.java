import java.io.Serializable;


public class Point{

    private Double x;
    private Double y;
    private Double r;
    private String res;

    public Point(){}

    public Point(Double x, Double y, Double r, String res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }


}
