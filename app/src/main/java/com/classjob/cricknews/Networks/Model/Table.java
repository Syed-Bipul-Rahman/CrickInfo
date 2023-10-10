package com.classjob.cricknews.Networks.Model;

public class Table {
    private String id;
    private String team;
    private String teamflag;
    private String matches;
    private String won;
    private String lost;
    private String pts;
    private String nrr;


    public Table(String id, String team, String teamflag, String matches, String won, String lost, String pts, String nrr) {
        this.id = id;
        this.team = team;
        this.teamflag = teamflag;
        this.matches = matches;
        this.won = won;
        this.lost = lost;
        this.pts = pts;
        this.nrr = nrr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamflag() {
        return teamflag;
    }

    public void setTeamflag(String teamflag) {
        this.teamflag = teamflag;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    public String getNrr() {
        return nrr;
    }

    public void setNrr(String nrr) {
        this.nrr = nrr;
    }
}
