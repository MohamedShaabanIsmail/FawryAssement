package com.mycompany.fawryassement;

import java.time.LocalDate;

import com.mycompany.fawryassement.interfaces.Expirable;

class ExpiryDate implements Expirable {
    private final LocalDate expiryDate;

    public ExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}