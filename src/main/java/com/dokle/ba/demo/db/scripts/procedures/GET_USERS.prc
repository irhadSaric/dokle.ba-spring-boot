create PROCEDURE GET_USERS(
    response OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN response FOR
        SELECT * FROM USERS;
END;
/

