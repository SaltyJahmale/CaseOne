package controller;

import database.JDBC;
import org.apache.http.util.TextUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dewi on 12.10.16.
 */
public class UploadFile {

    JDBC jdbc = new JDBC();

    public int insertFile(String file) throws SQLException {

        try {
            jdbc.getDBConnection();

            String query = "INSERT INTO STEVE.COURSES(COURSETITLE, COURSECODE, DURATION) VALUES(?, ?, ?)";
            PreparedStatement ps = jdbc.getDBConnection().prepareStatement(query);

            ps.setString(1, file);
            ps.setString(2, file);
            ps.setString(3, file);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if(jdbc.getDBConnection() != null) {
                jdbc.getDBConnection().close();
            }
        }

        return 0;
    }


    public static Map<String, String> splitToMap(String source, String entriesSeparator, String keyValueSeparator) {

        Map<String, String> map = new HashMap<>();
        String[] entries = source.split(entriesSeparator);

        for (String entry : entries) {
            if (!TextUtils.isEmpty(entry) && entry.contains(keyValueSeparator)) {
                String[] keyValue = entry.split(keyValueSeparator);
                map.put(keyValue[0], keyValue[1]);
            }
        }

        return map;
    }
    

}
