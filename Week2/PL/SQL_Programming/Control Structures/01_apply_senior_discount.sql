DECLARE

    CURSOR c_customers IS 
        SELECT customer_id, age, interest_rate 
        FROM customers;
BEGIN
    
    FOR r_cust IN c_customers LOOP
    
        IF r_cust.age > 60 THEN
    
            UPDATE customers
            SET interest_rate = interest_rate - 1
            WHERE customer_id = r_cust.customer_id;
        END IF;
    END LOOP;
    

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate discounts applied successfully.');
END;
/