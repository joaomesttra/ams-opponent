package br.com.mesttra.opponent.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorReponse {

    private String code;
    private String message;

}
