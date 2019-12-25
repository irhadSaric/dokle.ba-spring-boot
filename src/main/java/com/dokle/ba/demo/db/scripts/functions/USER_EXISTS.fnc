create function USER_EXISTS(email_in IN USERS.EMAIL%TYPE) return integer
IS
    l_counter integer;
BEGIN
    SELECT count(*) INTO l_counter FROM USERS WHERE EMAIL = email_in;
    return l_counter;

END;
/

