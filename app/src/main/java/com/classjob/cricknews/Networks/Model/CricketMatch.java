package com.classjob.cricknews.Networks.Model;
import java.util.List;

public class CricketMatch {
    private boolean success;
    private LiveScore livescore;

    public boolean isSuccess() {
        return success;
    }

    public LiveScore getLiveScore() {
        return livescore;
    }

    public class LiveScore {
        private String title;
        private String current;
        private String batsman;
        private String batsmanrun;
        private String ballsfaced;
        private String fours;
        private String sixes;
        private String sr;
        private String batsmantwo;
        private String batsmantworun;
        private String batsmantwoballsfaced;
        private String batsmantwofours;
        private String batsmantwosixes;
        private String batsmantwosr;
        private String bowler;
        private String bowlerover;
        private String bowlerruns;
        private String bowlewickets;
        private String bowlermaiden;
        private String bowlertwo;
        private String bowlertwoover;
        private String bowlertworuns;
        private String bowlertwowickets;
        private String bowlertwomaiden;
        private String partnership;
        private String recentballs;
        private String lastwicket;
        private String runrate;

        private String teamone;
        private String teamtwo;
        private String update;

        public String getTitle() {
            return title;
        }

        public String getCurrent() {
            return current;
        }

        public String getBatsman() {
            return batsman;
        }

        public String getBatsmanrun() {
            return batsmanrun;
        }

        public String getBallsfaced() {
            return ballsfaced;
        }

        public String getFours() {
            return fours;
        }

        public String getSixes() {
            return sixes;
        }

        public String getSr() {
            return sr;
        }

        public String getBatsmantwo() {
            return batsmantwo;
        }

        public String getBatsmantworun() {
            return batsmantworun;
        }

        public String getBatsmantwoballsfaced() {
            return batsmantwoballsfaced;
        }

        public String getBatsmantwofours() {
            return batsmantwofours;
        }

        public String getBatsmantwosixes() {
            return batsmantwosixes;
        }

        public String getBatsmantwosr() {
            return batsmantwosr;
        }

        public String getBowler() {
            return bowler;
        }

        public String getBowlerover() {
            return bowlerover;
        }

        public String getBowlerruns() {
            return bowlerruns;
        }

        public String getBowlewickets() {
            return bowlewickets;
        }

        public String getBowlermaiden() {
            return bowlermaiden;
        }

        public String getBowlertwo() {
            return bowlertwo;
        }

        public String getBowlertwoover() {
            return bowlertwoover;
        }

        public String getBowlertworuns() {
            return bowlertworuns;
        }

        public String getBowlertwowickets() {
            return bowlertwowickets;
        }

        public String getBowlertwomaiden() {
            return bowlertwomaiden;
        }

        public String getPartnership() {
            return partnership;
        }

        public String getRecentballs() {
            return recentballs;
        }

        public String getLastwicket() {
            return lastwicket;
        }

        public String getRunrate() {
            return runrate;
        }



        public String getTeamone() {
            return teamone;
        }

        public String getTeamtwo() {
            return teamtwo;
        }

        public String getUpdate() {
            return update;
        }
    }
}
