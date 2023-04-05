package tz.co.vodacom.bujikun.sportyshoes.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler(UsernameExiststException.class)
    public String registrationFailure(UsernameExiststException e, Model model){
        model.addAttribute("error",true);
        model.addAttribute("errorMessage",e.getMessage());
        model.addAttribute("user",e.getUser());
        return "account/register";
    }
}
