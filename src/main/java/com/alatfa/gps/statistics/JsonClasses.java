package com.alatfa.gps.statistics;

import java.util.Date;

/**
 * Created by UNKNOWN on 12/05/2016.
 */
public class JsonClasses {
    public class NbrMissionAvecDate{
        private int nbr;
        private String date;


        @Override
        public String toString() {
            return "NbrMissionAvecDate{" +
                    "nbr=" + nbr +
                    ", date='" + date + '\'' +
                    '}';
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getNbr() {
            return nbr;
        }

        public void setNbr(int nbr) {
            this.nbr = nbr;
        }
    }

}



