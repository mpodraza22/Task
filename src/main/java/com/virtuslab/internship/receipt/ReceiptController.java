package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptGenerator receiptGenerator;

    public ReceiptController(ReceiptGenerator receiptGenerator) {
        this.receiptGenerator = receiptGenerator;
    }


}
