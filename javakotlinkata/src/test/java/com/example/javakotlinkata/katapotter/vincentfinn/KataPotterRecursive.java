package com.example.javakotlinkata.katapotter.vincentfinn;

import java.util.List;
import java.util.stream.Collectors;

public class KataPotterRecursive {
    int bookCost = 8;

    public float purchase(List<Integer> bookCounts) {
        List<Integer> filteredList = bookCounts.stream()
                .filter(amount -> amount != 0)
                .collect(Collectors.toList());

        int filterBookCount = filteredList.size();

        if (filterBookCount == 0) {
            return 0f;
        }

        float discount = getDiscount(filterBookCount);
        List<Integer> removedOneFromEach = filteredList.stream().map(count -> count - 1).collect(Collectors.toList());

        return (float) (filterBookCount * bookCost) * (1 - discount) + purchase(removedOneFromEach);
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