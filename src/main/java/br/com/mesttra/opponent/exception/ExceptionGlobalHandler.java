package br.com.mesttra.opponent.exception;

import br.com.mesttra.opponent.response.ErrorReponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@ControllerAdvice
public class ExceptionGlobalHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public @ResponseBody List<ErrorReponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<ErrorReponse> errorReponses = new ArrayList<>();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {

            if (nonNull(error.getCodes()) && nonNull(error.getCodes()[0])) {
                String fieldName = error.getCodes()[0];

                StringBuilder message = new StringBuilder();
                message.append("The field ");
                message.append(fieldName.substring(fieldName.lastIndexOf(".") + 1));
                message.append(" ");
                message.append(error.getDefaultMessage());
                errorReponses.add(new ErrorReponse("X001", message.toString()));
            }
        }

        return errorReponses;
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(BusinessException.class)
    public @ResponseBody ErrorReponse handleBusinessException(BusinessException e) {
        return new ErrorReponse("X002", e.getMessage());
    }

}
