create or replace PROCEDURE REGISTER_USER(
    first_name_in IN USERS.FIRST_NAME%TYPE,
    last_name_in IN USERS.LAST_NAME%TYPE,
    email_in IN USERS.EMAIL%TYPE,
    password_in IN USERS.PASSWORD%TYPE,
    response OUT SYS_REFCURSOR)
    IS
    var_user_id NUMBER;
    var_code_id NUMBER;
BEGIN
    IF IRHAD.USER_EXISTS(email_in) = 0 then
        INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, STATUS_ID)
        VALUES (first_name_in, last_name_in, email_in, password_in, 2) RETURNING USERS.ID into var_user_id;
        COMMIT;

        INSERT INTO CODES (ACTIVATION_CODE) VALUES (DBMS_RANDOM.VALUE(9999, 1000)) RETURNING CODES.ID into var_code_id;

        INSERT INTO USER_CODES (USER_ID, CODE_ID) VALUES (var_user_id, var_code_id);

        OPEN response for
            SELECT * FROM USERS
            WHERE EMAIL = email_in;

        COMMIT;
    else
        open response for select * FROM USERS WHERE ID = -1;
    end if;
END;
/

