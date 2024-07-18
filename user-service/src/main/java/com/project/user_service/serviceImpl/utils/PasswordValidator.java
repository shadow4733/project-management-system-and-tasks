package com.project.user_service.serviceImpl.utils;

import org.passay.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PasswordValidator {
    private static final List<Rule> RULES = Arrays.asList(
        new LengthRule(8,30),
        new CharacterRule(EnglishCharacterData.Digit, 1),
        new CharacterRule(EnglishCharacterData.LowerCase, 1),
        new CharacterRule(EnglishCharacterData.UpperCase, 1),
        new CharacterRule(EnglishCharacterData.Special, 1),
        new WhitespaceRule()
    );

    public boolean isPasswordValid(String password){
        PasswordData passwordData = new PasswordData(password);
        RuleResult result = new org.passay.PasswordValidator(RULES).validate(passwordData);
        return result.isValid();
    }

}
