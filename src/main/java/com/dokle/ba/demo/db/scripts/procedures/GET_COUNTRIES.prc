create PROCEDURE GET_COUNTRIES(
    response OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN response FOR
        SELECT * FROM COUNTRIES;
END;
/

