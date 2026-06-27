CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_current_balance NUMBER;
BEGIN

    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    
    SELECT balance INTO v_current_balance
    FROM accounts
    WHERE account_id = p_from_account
    FOR UPDATE;

    IF v_current_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds in the source account.');
    END IF;

    
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;


    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || 
                         ' from account ' || p_from_account || 
                         ' to account ' || p_to_account || '.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
    
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END TransferFunds;
/