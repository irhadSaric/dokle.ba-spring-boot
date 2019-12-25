create PROCEDURE GET_USER_BY_ID(
    userId IN USERS.ID%TYPE,
    response OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN response FOR
        SELECT * FROM USERS WHERE ID=userId;
END;
/

