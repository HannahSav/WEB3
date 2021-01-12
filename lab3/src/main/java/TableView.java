import java.util.ArrayList;


public class TableView {


    private PointDao pointDao = new PointDao();

    public ArrayList<Point> getAll() throws Exception {
        return pointDao.getAll();
    }

    public void clearAll() throws Exception {
        pointDao.clearAll();
    }


}