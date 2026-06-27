DECLARE
    CURSOR c_balances IS 
        SELECT customer_id, balance 
        FROM customers;
BEGIN
    FOR r_cust IN c_balances LOOP
    
        IF r_cust.balance > 10000 THEN

            UPDATE customers
            SET IsVIP = 'TRUE' 
            WHERE customer_id = r_cust.customer_id;
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP statuses updated successfully.');
END;
/