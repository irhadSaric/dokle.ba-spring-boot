create PROCEDURE ACTIVATE_USER(
    user_id_in IN USERS.ID%TYPE,
    activation_code_in IN CODES.ACTIVATION_CODE%TYPE,
    response OUT SYS_REFCURSOR)
IS
    db_activation_code CODES.ACTIVATION_CODE%TYPE;
BEGIN
    if(USER_EXISTS_ID(user_id_in) >= 1) then
        SELECT ACTIVATION_CODE INTO db_activation_code FROM CODES
                    INNER JOIN USER_CODES ON CODES.ID = USER_CODES.CODE_ID
                    INNER JOIN USERS ON USER_CODES.USER_ID = USERS.ID
                    WHERE USERS.ID = user_id_in;
        DBMS_OUTPUT.PUT_LINE(db_activation_code);
        IF activation_code_in = db_activation_code then
            UPDATE USERS SET STATUS_ID = 1 WHERE ID = user_id_in;
            begin
                OPEN response FOR
                    SELECT * FROM USERS WHERE ID=user_id_in;
            end;
        end if;
    end if;
END;
/

