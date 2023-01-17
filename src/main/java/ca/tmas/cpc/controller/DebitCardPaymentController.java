package ca.tmas.cpc.controller;

import ca.tmas.cpc.service.DebitCardPaymentService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/debitcardpayments")
@Slf4j
@Setter
public class DebitCardPaymentController {

    private ModelMapper mapper;

    private DebitCardPaymentService debitCardPaymentService;

}
