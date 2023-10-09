
package com.classjob.cricknews.Networks.Model;

public class Matches {
    private String date;
    private String messege;
    private int serial;
    private String matchName;
    private String lossCountryName;
    private String winCountryName;
    private String winCountryFlag;
    private String lossCountryFlag;
    private String lossCountryRunover;
    private String winCountryRunover;

    public Matches(String date, String messege, int serial, String matchName, String lossCountryName, String winCountryName, String winCountryFlag, String lossCountryFlag, String lossCountryRunover, String winCountryRunover) {
        this.date = date;
        this.messege = messege;
        this.serial = serial;
        this.matchName = matchName;
        this.lossCountryName = lossCountryName;
        this.winCountryName = winCountryName;
        this.winCountryFlag = winCountryFlag;
        this.lossCountryFlag = lossCountryFlag;
        this.lossCountryRunover = lossCountryRunover;
        this.winCountryRunover = winCountryRunover;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getLossCountryName() {
        return lossCountryName;
    }

    public void setLossCountryName(String lossCountryName) {
        this.lossCountryName = lossCountryName;
    }

    public String getWinCountryName() {
        return winCountryName;
    }

    public void setWinCountryName(String winCountryName) {
        this.winCountryName = winCountryName;
    }

    public String getWinCountryFlag() {
        return winCountryFlag;
    }

    public void setWinCountryFlag(String winCountryFlag) {
        this.winCountryFlag = winCountryFlag;
    }

    public String getLossCountryFlag() {
        return lossCountryFlag;
    }

    public void setLossCountryFlag(String lossCountryFlag) {
        this.lossCountryFlag = lossCountryFlag;
    }

    public String getLossCountryRunover() {
        return lossCountryRunover;
    }

    public void setLossCountryRunover(String lossCountryRunover) {
        this.lossCountryRunover = lossCountryRunover;
    }

    public String getWinCountryRunover() {
        return winCountryRunover;
    }

    public void setWinCountryRunover(String winCountryRunover) {
        this.winCountryRunover = winCountryRunover;
    }
}
