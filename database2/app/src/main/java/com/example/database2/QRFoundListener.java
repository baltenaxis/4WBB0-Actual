package com.example.database2;

public interface QRFoundListener {

    void onQRCodeFound(String qrCode);

    void qrCodeNotFound();
}