
public class SubmitView {
    PointDao pointDao = new PointDao();
    Double selectedX;
    Double selectedY;
    Double selectedR;
    Double clickedX;
    Double clickedY;

    public SubmitView(){
        this.selectedX = 0d;
        this.selectedY = 0d;
        this.selectedR = 3.5d;
    }



    public Double getSelectedX() {
        return selectedX;
    }


    public Double getSelectedY() {
        return selectedY;
    }

    public Double getSelectedR() {
        return selectedR;
    }


    private boolean checkValues(Double selectedX, Double selectedY, Double selectedR){
        if ((selectedX!=null)&&(selectedY!=null)&&(selectedR!=null)){
            return (selectedY >= -5) && (selectedY <= 5) && (selectedX>=-4) && (selectedR*100 % 10 == 0) && (selectedX*10 % 10 == 0) && (selectedX<=4) && (selectedR>=2) && (selectedR<=5);
        }
        else return false;
    }

    private String checkHit(Double x, Double y, Double r){
        if (((x>=-r/2)&&(x<=0)&&(y<=0)&&(y>=-r/2-x)) || ((x>=-r/2)&&(x<=0)&&(y>=0)&&(y<=r)) || (x>=0)&&(y<=0)&&(x*x+y*y<=r*r/4)) return "YES";
        else return "NO";
    }

    public void setSelectedX(Double selectedX) {
        this.selectedX = selectedX;
    }

    public void setSelectedY(Double selectedY) {
        this.selectedY = selectedY;
    }

    public void setSelectedR(Double selectedR) {
        this.selectedR = selectedR;
    }

    public Double getClickedX() {
        return clickedX;
    }

    public void setClickedX(Double clickedX) {
        this.clickedX = clickedX;
    }

    public Double getClickedY() {
        return clickedY;
    }

    public void setClickedY(Double clickedY) {
        this.clickedY = clickedY;
    }

    public void submit() throws Exception {
        if (!checkValues(selectedX, selectedY, selectedR)) return;
        String currentResult = checkHit(selectedX, selectedY, selectedR);
        Point point = new Point(selectedX,selectedY,selectedR,currentResult);
        pointDao.insertPoint(point);

    }

    public void submitByClick() throws Exception {
        if (!checkValues(clickedX,clickedY,selectedR)) return;
        String currentResult = checkHit(clickedX,clickedY,selectedR);
        Point point = new Point(clickedX,clickedY,selectedR,currentResult);
        pointDao.insertPoint(point);
    }







}
