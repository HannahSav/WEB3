import java.sql.*;
import java.util.ArrayList;

public class PointDao {

    Connection connection;

    public void initConnection() throws Exception {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://pg:5432/studs", "KorolIShut", "xxxxx");
            connection.createStatement().execute("create table if not exists points286536(x float, y float, r float, result char(10))");
        } catch (SQLException e) {throw new Exception("Couldn't create connection");}
    }

    public void insertPoint(Point point) throws Exception {
        if (connection==null) initConnection();

        PreparedStatement statement = connection.prepareStatement("insert into points286536 (x, y, r, result) values (?, ?, ?, ?)");

        statement.setDouble(1, point.getX());
        statement.setDouble(2, point.getY());
        statement.setDouble(3, point.getR());
        statement.setString(4, point.getRes());

        statement.execute();
    }


    public ArrayList<Point> getAll() throws Exception {
        if (connection == null) initConnection();

        ResultSet resultSet = connection.createStatement().executeQuery("select * from points286536");
        ArrayList<Point> points = new ArrayList<>();
        while (resultSet.next()) {
            Point currentPoint = new Point();
            currentPoint.setX(resultSet.getDouble("x"));
            currentPoint.setY(resultSet.getDouble("y"));
            currentPoint.setR(resultSet.getDouble("r"));
            currentPoint.setRes(resultSet.getString("result"));
            points.add(currentPoint);
        }

        return points;
    }


    public void clearAll() throws Exception{
        if (connection == null) initConnection();
        connection.createStatement().execute("delete from points286536");
    }
}
