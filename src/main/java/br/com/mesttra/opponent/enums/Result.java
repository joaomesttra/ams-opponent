package br.com.mesttra.opponent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Result {

    LOSS("LOSS"), WIN("WIN"), DRAW("DRAW");

    private final String value;

}
