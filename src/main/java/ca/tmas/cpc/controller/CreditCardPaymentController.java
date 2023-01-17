package ca.tmas.cpc.controller;

import ca.tmas.cpc.service.CreditCardPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/creditcardpayments")
@Slf4j
@Setter
public class CreditCardPaymentController {

    private ModelMapper mapper;

    private CreditCardPaymentService creditCardPaymentService;

}
