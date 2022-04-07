package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.Discount;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import com.virtuslab.internship.product.Product;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@Component
public class ReceiptGenerator {
    private final List<Discount> discounts;

    public ReceiptGenerator() {
        this.discounts = List.of(new FifteenPercentDiscount(), new TenPercentDiscount());
    }


    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        HashMap<Product, Integer> productCounter = new HashMap<>();
        for (Product product : basket.getProducts()) {
            productCounter.put(product, productCounter.getOrDefault(product, 0) + 1);
        }

        for (Map.Entry<Product, Integer> entry : productCounter.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            receiptEntries.add(new ReceiptEntry(key, value));
        }

        Receipt receipt = new Receipt(receiptEntries);

        for (Discount discount : discounts) {
            receipt = discount.apply(receipt);
        }

        return receipt;
    }
}
