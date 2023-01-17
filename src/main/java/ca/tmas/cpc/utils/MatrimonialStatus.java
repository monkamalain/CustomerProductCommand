package ca.tmas.cpc.utils;

public enum MatrimonialStatus {

    CELIBATAIRE("CELIBATAIRE"),
    MARIE("MARIE(E)"),
    MARIEE("MARIEE"),
    DIVORCE("DIVORCE"),
    VEUF("VEUF"),
    VEUVE("VEUVE");

    private String s;

    MatrimonialStatus(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
