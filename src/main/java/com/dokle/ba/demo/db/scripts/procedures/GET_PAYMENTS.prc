create PROCEDURE GET_PAYMENTS(
    response OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN response FOR
        SELECT * FROM PAYMENTS;
END;
/

