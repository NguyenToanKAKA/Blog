create database findjob
Go
use findjob
Go

CREATE TABLE Roles (
    RoleID INT IDENTITY(1,1) PRIMARY KEY,
    RoleName VARCHAR(50)
);

CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    Email VARCHAR(100) UNIQUE,
    Password VARCHAR(100),
    RoleID INT,
	[Message] VARCHAR(50),
	City VARCHAR(100),
	PhoneNumber Int,
	DateOfBirth Date,
    Status VARCHAR(50),
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);
CREATE TABLE CVProfile(
    CVId INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    Skills VARCHAR(MAX),
    Experience VARCHAR(MAX),
	[Description] VARCHAR(MAX),
    Education VARCHAR(MAX),
    Certifications VARCHAR(MAX),
	LinkUrl VARCHAR(MAX),
	Number INT,

    FOREIGN KEY (UserID) REFERENCES Users(UserID),
	
);