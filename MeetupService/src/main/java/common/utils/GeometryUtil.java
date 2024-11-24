package common.utils;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

public class GeometryUtil {
    public static String toWKT(Geometry geometry) {
        if (geometry == null) return null;
        WKTWriter writer = new WKTWriter();
        return writer.write(geometry);
    }

    public static Geometry stringToGeometry(String wkt) {
        try {
            WKTReader reader = new WKTReader();
            return reader.read(wkt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
