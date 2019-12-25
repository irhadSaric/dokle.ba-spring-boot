create PROCEDURE LOGIN(
    email_in IN USERS.EMAIL%TYPE,
    response OUT USERS.PASSWORD%TYPE)
    IS
BEGIN
    IF USER_EXISTS(email_in) >= 1 then
        begin
            SELECT PASSWORD INTO response FROM USERS WHERE EMAIL = email_in;
        end;
    ELSE
        begin
            response := 'Email not found';
        end;
    end if;
END;
/

