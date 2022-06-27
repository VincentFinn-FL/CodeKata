package com.example.javakata.katapotter.vincentfinn;

import java.util.List;
import java.util.stream.Collectors;

public class KataPotterNonRecursive {
    int bookCost = 8;

    public float purchase(List<Integer> bookCounts) {
        List<Integer> filteredList = bookCounts.stream()
                .filter(amount -> amount != 0)
                .collect(Collectors.toList());

        float totalCost = 0f;

        while (!filteredList.isEmpty()) {
            float setCost = filteredList.size() * bookCost;
            float discount = getDiscount(filteredList.size());
            totalCost += setCost * (1 - discount);
            filteredList = filteredList.stream()
                    .map(count -> count - 1)
                    .filter(amount -> amount != 0)
                    .collect(Collectors.toList());
        }

        return totalCost;
    }

    private float getDiscount(int filterBookCount) {
        float discount = 0f;
        switch (filterBookCount) {
            case 2:
                discount = .05f;
                break;
            case 3:
                discount = .10f;
                break;
            case 4:
                discount = .20f;
                break;
            case 5:
                discount = .25f;
                break;
            default:
                break;
        }
        return discount;
    }
}