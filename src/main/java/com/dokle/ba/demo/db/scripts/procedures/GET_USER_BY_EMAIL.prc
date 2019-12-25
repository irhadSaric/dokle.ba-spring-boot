create PROCEDURE GET_USER_BY_EMAIL(
    email_in IN USERS.EMAIL%TYPE,
    response OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN response FOR
        SELECT * FROM USERS WHERE EMAIL=email_in;
END;
/

