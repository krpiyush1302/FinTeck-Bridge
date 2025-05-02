use BankDB




CREATE TABLE Users (
    user_id INT IDENTITY PRIMARY KEY,
    full_name VARCHAR(100),
    gender VARCHAR(10),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(255),
    dob DATE,
    aadhar VARCHAR(20),
    pan VARCHAR(20),
    password VARCHAR(100),
    account_number VARCHAR(20) UNIQUE,
    balance DECIMAL(15,2) DEFAULT 0.00,
    created_at DATETIME DEFAULT GETDATE(),
    created_day AS DATENAME(WEEKDAY, created_at)
    
);


CREATE TABLE Transactions (
    transaction_id INT IDENTITY PRIMARY KEY,
    account_number VARCHAR(20),
    type VARCHAR(10),  -- Deposit, Withdraw, Transfer
    amount DECIMAL(15, 2),
    description VARCHAR(255),
    date_time DATETIME DEFAULT GETDATE()
);


CREATE TABLE Loans (
    loan_id INT PRIMARY KEY IDENTITY,
    account_number VARCHAR(20),
    loan_type VARCHAR(50),
    amount DECIMAL(12,2),
    tenure_months INT,
    interest_rate FLOAT,
    emi DECIMAL(10,2),
    status VARCHAR(20), -- Pending / Approved / Rejected
    request_date DATETIME DEFAULT GETDATE()
);

CREATE TABLE FixedDeposits (
    fd_id INT PRIMARY KEY IDENTITY,
    account_number VARCHAR(20),
    amount DECIMAL(10, 2),
    tenure_months INT,
    interest_rate DECIMAL(5, 2),
    start_date DATE,
    maturity_amount DECIMAL(10, 2),
    maturity_date DATE
);
select *from FixedDeposits


CREATE TABLE BillPayments (
    id INT IDENTITY PRIMARY KEY,
    account_number VARCHAR(20),
    bill_type VARCHAR(50),
    payee_name VARCHAR(100),
    amount DECIMAL(10, 2),
    payment_date DATETIME DEFAULT GETDATE()
);


CREATE TABLE Cards (
    id INT IDENTITY PRIMARY KEY,
    account_number VARCHAR(20),
    card_number VARCHAR(20),
    card_holder_name VARCHAR(100),
    expiry_date DATE,
    cvv VARCHAR(4),
    issued_on DATE DEFAULT GETDATE()
);

CREATE TABLE ServiceRequests (
    id INT IDENTITY PRIMARY KEY,
    account_number VARCHAR(20),
    request_type VARCHAR(50),
    message VARCHAR(255),
    status VARCHAR(20) DEFAULT 'Pending',
    requested_on DATETIME DEFAULT GETDATE()
);


CREATE TABLE Nominees (
    account_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    relationship VARCHAR(50),
    dob DATE,
    contact VARCHAR(100),
    CONSTRAINT FK_Nominee_User FOREIGN KEY (account_number) 
        REFERENCES Users(account_number)
        ON DELETE CASCADE
);
select * from Nominees

ALTER TABLE Users
ADD upi_pin_hash VARCHAR(255);


select *from Users

