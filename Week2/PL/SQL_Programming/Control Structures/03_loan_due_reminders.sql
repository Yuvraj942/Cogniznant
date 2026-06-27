DECLARE
    CURSOR c_due_loans IS 
        SELECT customer_id, loan_id, due_date 
        FROM loans
        WHERE due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    
    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Customer ID ' || r_loan.customer_id || 
                             ' - Your loan (' || r_loan.loan_id || 
                             ') is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/