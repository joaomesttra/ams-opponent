package br.com.mesttra.opponent.enums;

public enum Formation {

    F433("4-3-3"), F451("4-5-1"), F352("3-5-2");

    private final String value;

    Formation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
