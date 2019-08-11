package org.randall.teagan.Domains.Demography;

public class Race {
    private String raceID, raceDesc;

    private Race(){}

    private Race(RaceBuilder raceBuilder){
        this.raceID = raceBuilder.raceID;
        this.raceDesc = raceBuilder.raceDesc;
    }

    public String getRaceID() {
        return raceID;
    }

    public String getRaceDesc() {
        return raceDesc;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceID='" + raceID + '\'' +
                ", raceDesc='" + raceDesc + '\'' +
                '}';
    }

    public static class RaceBuilder{
        private String raceID, raceDesc;

        public RaceBuilder raceID(String raceID){
            this.raceID = raceID;
            return this;
        }

        public RaceBuilder raceDesc(String raceDesc) {
            this.raceDesc = raceDesc;
            return this;
        }

        public RaceBuilder copy(Race race) {
            this.raceID = race.raceID;
            this.raceDesc = race.raceDesc;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }
}
