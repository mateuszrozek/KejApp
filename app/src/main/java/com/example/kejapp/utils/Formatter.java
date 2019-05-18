package com.example.kejapp.utils;

public class Formatter {

    public String printMetersFromDouble(Double d) {
        if (d == null) return "N/A";
        else return Double.toString(d) + " m";
    }

    public String printPriceFromDouble(Double d) {
        if (d == null) return "N/A";
        else return Double.toString(d) + " PLN";
    }

    public String printNamesFromString(String s) {
        if (s == null) return "N/A";
        else return s;
    }

    public String printStringFromLocalDateTime(String date) {
        if (date == null) return "N/A";
        else return date;
    }

    public String printStringFromNumber(Long quayNumber) {
        if (quayNumber == null) return "N/A";
        else return quayNumber.toString();
    }

    public String printStringFromBoolean(Boolean flag) {
        if (flag == null) return "N/A";
        else return flag.toString();
    }

    public String printLatLngFromDouble(Double coordinate){
        if (coordinate == null) return "N/A";
        else {
            return convertCoordinate(coordinate);
        }
    }

    private String convertCoordinate(Double coordinate) {
        int grades = (int)Math.round(coordinate);
        double rest = coordinate - grades;
        double sec = rest * 3600;
        double seconds = sec % 60;
        double minutes = (sec - seconds)/60;

        return grades + "°" + minutes + "'" + seconds + "\"";
    }
}
