DROP DATABASE IF EXISTS tester;
CREATE DATABASE tester CHARACTER SET utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


CREATE TABLE tester.authorities
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY,
    username VARCHAR(3000) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    INDEX(authority)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.users
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    password TEXT(1000) NOT NULL,
    enabled BIT(1) NOT NULL,
    acceptedTermsAndConditionsAndPrivacyNotice BIT(1),
    loggedIn BIT(1),
    lastLogInDate VARCHAR(10),
    lastLogInTime VARCHAR(8),
    registrationDate VARCHAR(10) NOT NULL,
    registrationTime VARCHAR(8) NOT NULL,
    numberOfAccountLockdowns INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.users_security_questions
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    securityQuestion1 VARCHAR(1000) NOT NULL,
    securityQuestionAnswer1 VARCHAR(1000) NOT NULL,
    securityQuestion2 VARCHAR(1000) NOT NULL,
    securityQuestionAnswer2 VARCHAR(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_logout_causes
(
    id1 INT NOT NULL PRIMARY KEY,
    logoutCause VARCHAR(6) NOT NULL,
    INDEX(logoutCause)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_logouts
(
    id1 BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userID VARCHAR(255) NOT NULL REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    logoutDate VARCHAR(10) NOT NULL,
    logoutTime VARCHAR(12) NOT NULL,
    logoutCauseID BIGINT NOT NULL REFERENCES tester.user_logout_causes(id1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_logins
(
    id1 BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userID VARCHAR(255) NOT NULL REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    loginDate VARCHAR(10) NOT NULL,
    loginTime VARCHAR(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_failed_login_attempts
(
    userID VARCHAR(255) NOT NULL REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    IPAddress VARCHAR(15),
    firstFailedLoginAttemptDate VARCHAR(10),
    firstFailedLoginAttemptTime VARCHAR(8),
    failedLoginAttempts INT,
    accountDisabled BIT(1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_old_passwords
(
    id1 BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userID VARCHAR(255) NOT NULL REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    password TEXT(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.email_validation_codes
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    emailValidationCode TEXT(1000) NOT NULL,
    emailValidationCodeExpiryDatetime BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.user_details
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    emailAddress VARCHAR(3000) NOT NULL,
    avatarURL VARCHAR(1000),
    selectedTheme VARCHAR(50),
    firstName LONGTEXT,
    middleName LONGTEXT,
    lastName LONGTEXT,
    fullNameOfSecondTenant LONGTEXT,
    birthdate VARCHAR(10),
    mobileNumber LONGTEXT,
    nationalityCountryCode VARCHAR(3),
    nationality VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE tester.forgot_password_codes
(
    userID VARCHAR(255) NOT NULL PRIMARY KEY REFERENCES tester.authorities(userID) ON DELETE CASCADE ON UPDATE CASCADE,
    forgotPasswordCode TEXT(1000) NOT NULL,
    forgotPasswordCodeExpiryDatetime BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO tester.user_logout_causes(id1, logoutCause) VALUES(1, 'user');
INSERT INTO tester.user_logout_causes(id1, logoutCause) VALUES(2, 'system');


/*UPDATE tester.authorities SET authority='ROLE_ADMINISTRATOR' WHERE username='efthymiou.dimitrios1@gmail.com';*/