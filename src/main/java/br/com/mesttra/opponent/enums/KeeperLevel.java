package br.com.mesttra.opponent.enums;

public enum KeeperLevel {

    BAD(1), OK(2), GOOD(3), VERY_GOOD(4), EXCELENT(5);

    private final Integer value;

    KeeperLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
