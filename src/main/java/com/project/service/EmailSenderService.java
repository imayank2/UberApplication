package com.project.service;

public interface EmailSenderService {
    public void sendEmail(String toEmail, String subject, String body);

     void sendEmail(String toEmail[],String subject, String body);
}
