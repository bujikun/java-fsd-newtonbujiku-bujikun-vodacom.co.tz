package tz.co.vodacom.bujikun.sportyshoes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderNotFoundException extends RuntimeException{
    private  String message;
}

