CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';
    
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% processed for all savings accounts.');

EXCEPTION
    WHEN OTHERS THEN
        
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/